package com.spring_REST;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockOverview {

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;
    
    public StockOverview() {

    }

    public StockOverview(String symbol, String name, String description) {
        this.symbol = symbol;
        this.name = name;
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
