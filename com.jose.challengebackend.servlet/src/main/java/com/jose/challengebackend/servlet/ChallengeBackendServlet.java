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
			@QueryParam("begindate") String beginDate, @QueryParam("finaldate") String finalDate,
			@QueryParam("name") String name, @QueryParam("code") String code, @QueryParam("weight") String weight,
			@QueryParam("height") String height, @QueryParam("width") String width, @QueryParam("length") String length)
			throws IOException {
		Collection<Map<String, Object>> filteredMap = new ArrayList<>();

		Gson gson = new Gson();
		try {
			Response response = ClientBuilder.newClient().target(URI).request().get();

			String responseEntity = response.readEntity(String.class);
			if (String.valueOf(response.getStatus()).charAt(0) != '2') throw new Exception(responseEntity);

			Collection<Map<String, Object>> responseMap = gson.fromJson(responseEntity, Collection.class);
			for (Map<String, Object> map : responseMap) {
				if (add(beginDate, finalDate, name, code, weight, height, width, length, map)) filteredMap.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gson.toJson(filteredMap);
	}

	private boolean add(String beginDate, String finalDate, String name, String code, String weight, String height,
			String width, String length, Map<String, Object> map) throws Exception {
		SimpleDateFormat euaSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat brSdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		if (beginDate != null && !beginDate.isEmpty() && finalDate != null && !finalDate.isEmpty()) {
			Date mapDate = euaSdf.parse(map.get("date").toString().replace("T", " "));
			Date initialDate = brSdf.parse(beginDate + " 00:00:00");
			Date endDate = brSdf.parse(finalDate + " 23:59:59");
			if (mapDate.before(initialDate) || mapDate.after(endDate)) return false;
		}
		if (code != null && !code.isEmpty() && !code.equals(map.get("code").toString())) return false;
		if (name != null && !name.isEmpty() && !map.get("name").toString().contains(name)) return false;

		Map<String, Object> dimension = (Map<String, Object>) map.get("dimension");
		if (width != null && !width.isEmpty() && !Double.valueOf(width).equals(dimension.get("width"))) return false;
		if (height != null && !height.isEmpty() && !Double.valueOf(height).equals(dimension.get("height")))
			return false;
		if (weight != null && !weight.isEmpty() && !Double.valueOf(weight).equals(dimension.get("weight")))
			return false;
		if (length != null && !length.isEmpty() && !Double.valueOf(length).equals(dimension.get("length")))
			return false;
		return true;
	}
}
