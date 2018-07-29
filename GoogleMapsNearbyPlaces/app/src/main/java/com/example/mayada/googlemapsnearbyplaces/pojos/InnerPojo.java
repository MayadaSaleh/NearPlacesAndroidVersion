package com.example.mayada.googlemapsnearbyplaces.pojos;

import java.util.List;

/**
 * Created by Mayada on 7/29/2018.
 */

public class InnerPojo {

    private String id;
    private String place_id;
    private String icon;
    private String vicinity;
    private String scope;
    private String name;
    private String rating;
    private String[] types;
    private String reference;
    private String opening_hours;
    private List<GeometryPojo> geometry;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public List<GeometryPojo> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<GeometryPojo> geometry) {
        this.geometry = geometry;
    }
}
