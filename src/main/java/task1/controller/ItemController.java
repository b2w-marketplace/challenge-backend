package task1.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task1.exception.ItemsProviderException;
import task1.models.Item;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping(value = "/challenge-backend")
public class ItemController {

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public List<Item> item(
        @RequestParam(value="begindate") String beginDate,
        @RequestParam(value="finaldate") String finalDate
    ) {
        String itemsAvailableStr = getItemsAvailable();

        Type listType = new TypeToken<ArrayList<Item>>(){}.getType();
        List<Item> items = new Gson().fromJson(itemsAvailableStr, listType);
        return items.stream().filter(item -> item.onValidPeriod(beginDate, finalDate)).collect(toList());
    }

    private static String getItemsAvailable() {
        try {
            URL urlForGetRequest = new URL("http://www.mocky.io/v2/5817803a1000007d01cc7fc9");
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) throw new ItemsProviderException();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String readLine;
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            return response.toString();
        } catch (ItemsProviderException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ItemsProviderException();
        }
    }

}
