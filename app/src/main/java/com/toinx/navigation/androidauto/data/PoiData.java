package com.toinx.navigation.androidauto.data;

/**
 * Created by toinx on 29/03/2023.
 */
public class PoiData {
    private String title;
    private double latitude;
    private double longitude;

    public PoiData(String title, double latitude, double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String buildPoiNavigationIntent() {
        return "google.navigation:q=" + latitude + "," + longitude;
    }

    public String getSubtitle() {
        return latitude + "," + longitude;
    }
}
