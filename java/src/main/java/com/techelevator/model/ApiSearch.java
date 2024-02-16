package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiSearch {


    @JsonProperty("Search")
    private List<ApiMovie> search;

    public List<ApiMovie> getSearch() {
        return search;
    }

    public void setSearch(List<ApiMovie> search) {
        this.search = search;
    }
}
