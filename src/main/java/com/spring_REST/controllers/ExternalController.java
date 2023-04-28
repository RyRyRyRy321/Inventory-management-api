package com.spring_REST.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring_REST.StockOverview;

@RestController
@RequestMapping("/api")
public class ExternalController {

    private final String API_KEY = "C2J0QUTNFV2PF4I5";
    private final String BASE_URL = "https://www.alphavantage.co/query?";
    

    @GetMapping("overview/{symbol}")
    public StockOverview getOverview(@PathVariable String symbol){
        String url = BASE_URL + "function=OVERVIEW" + "&symbol=" + symbol + "&apikey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();

        StockOverview stockOverview = restTemplate.getForObject(url, StockOverview.class);

        return stockOverview;
    }

    @GetMapping("overviewAll/{symbol}")
    public String getOverviewAll(@PathVariable String symbol){
        String url = BASE_URL + "function=OVERVIEW" + "&symbol=" + symbol + "&apikey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
