package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mayada on 7/30/2018.
 */

public class OuterDirectionAPIPojo implements Serializable{

    private String status;

    private List<RoutePojo> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RoutePojo> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutePojo> routes) {
        this.routes = routes;
    }
}
