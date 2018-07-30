package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.io.Serializable;

/**
 * Created by Mayada on 7/30/2018.
 */

public class RoutePojo implements Serializable {

    private Overview_polyline overview_polyline;

    public Overview_polyline getOverview_polyline() {
        return overview_polyline;
    }

    public void setOverview_polyline(Overview_polyline overview_polyline) {
        this.overview_polyline = overview_polyline;
    }
}
