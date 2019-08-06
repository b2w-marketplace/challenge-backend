package com.jose.challengebackend.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/challenge-backend/")
public class ChallengeBackendServlet {

	private static final String URI = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

	@GET
	@Path("item")
	public String item(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@QueryParam("begindate") String beginDate, @QueryParam("finaldate") String finalDate) throws IOException {
		Collection<Map<String, String>> filteredMap = new ArrayList<>();

		SimpleDateFormat euaSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat brSdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Gson gson = new Gson();
		try {
			if (beginDate == null || beginDate.isEmpty() || finalDate == null || finalDate.isEmpty())
				throw new Exception("Data inicial e data final devem ser informadas");

			Response response = ClientBuilder.newClient().target(URI).request().get();

			String responseEntity = response.readEntity(String.class);
			if (String.valueOf(response.getStatus()).charAt(0) != '2') throw new Exception(responseEntity);

			Collection<Map<String, String>> responseMap = gson.fromJson(responseEntity, Collection.class);
			for (Map<String, String> map : responseMap) {
				Date mapDate = euaSdf.parse(map.get("date").replace("T", " "));
				Date initialDate = brSdf.parse(beginDate + " 00:00:00");
				Date endDate = brSdf.parse(finalDate + " 23:59:59");
				if (mapDate.after(initialDate) && mapDate.before(endDate)) filteredMap.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(filteredMap);
	}
}
