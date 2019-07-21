package com.b2wchallenge.rafaelteixeira.backendchallenge.controller;

import com.b2wchallenge.rafaelteixeira.backendchallenge.model.Item;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/challenge-backend")
public class ItemController {

    private static final String URL_API = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String show(@RequestParam(value = "begindate") final String beginDate,
                       @RequestParam(value = "finaldate") final String finalDate) throws Exception {

        //change the type string to date
        Date bDate = stringToDate(beginDate);
        Date fDate = stringToDate(finalDate);

        //add one day to include the last item in the response
        Calendar c = Calendar.getInstance();
        c.setTime(fDate);
        c.add(Calendar.DATE, +1);
        fDate = c.getTime();

        String JSON = readUrl(URL_API);
        Gson gson = new Gson();
        Item[] items = gson.fromJson(JSON, Item[].class);

        List<Item> itemsFilter = new ArrayList<Item>();
        for( int i = 0; i < items.length; i++ ){
            if(items[i].getDate().after(bDate) && items[i].getDate().before(fDate)){
                itemsFilter.add(items[i]);
            }
        }
        return gson.toJson(itemsFilter);
    }

    private static String readUrl(String urlString) throws Exception{

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            return response.toString();
    }

    private Date stringToDate(String stringDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(stringDate);
        return date;
    }
}
