package com.b2wchallenge.rafaelteixeira.backendchallenge.controller;

import com.b2wchallenge.rafaelteixeira.backendchallenge.model.Item;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



@RestController
@RequestMapping("/challenge-backend")
public class ItemController {

    private static final String URL_API = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String show() throws Exception {
        String JSON = readUrl(URL_API);
        Gson gson = new Gson();
        Item[] items = gson.fromJson(JSON, Item[].class);
        for(int i = 0; i < items.length; i++){
            System.out.println(items[i].toString() + "\n\n");
        }
        return gson.toJson(items);
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
}
