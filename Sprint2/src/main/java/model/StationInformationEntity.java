package model;

import java.util.List;

public class StationInformationEntity {
    private String station_id;
    private String external_id;
    private String name;
    private String short_name;
    private double lat;
    private double lon;
    private List<String> rental_methods;
    private int capacity;
    private boolean electric_bike_surcharge_waiver;
    private boolean is_charging;
    private boolean eightd_has_key_dispenser;
    private boolean has_kiosk;

    public StationInformationEntity() {
    }

    public StationInformationEntity(String station_id, String external_id, String name, String short_name, double lat, double lon, List<String> rental_methods, int capacity, boolean electric_bike_surcharge_waiver, boolean is_charging, boolean eightd_has_key_dispenser, boolean has_kiosk) {
        this.station_id = station_id;
        this.external_id = external_id;
        this.name = name;
        this.short_name = short_name;
        this.lat = lat;
        this.lon = lon;
        this.rental_methods = rental_methods;
        this.capacity = capacity;
        this.electric_bike_surcharge_waiver = electric_bike_surcharge_waiver;
        this.is_charging = is_charging;
        this.eightd_has_key_dispenser = eightd_has_key_dispenser;
        this.has_kiosk = has_kiosk;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public List<String> getRental_methods() {
        return rental_methods;
    }

    public void setRental_methods(List<String> rental_methods) {
        this.rental_methods = rental_methods;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isElectric_bike_surcharge_waiver() {
        return electric_bike_surcharge_waiver;
    }

    public void setElectric_bike_surcharge_waiver(boolean electric_bike_surcharge_waiver) {
        this.electric_bike_surcharge_waiver = electric_bike_surcharge_waiver;
    }

    public boolean isIs_charging() {
        return is_charging;
    }

    public void setIs_charging(boolean is_charging) {
        this.is_charging = is_charging;
    }

    public boolean isEightd_has_key_dispenser() {
        return eightd_has_key_dispenser;
    }

    public void setEightd_has_key_dispenser(boolean eightd_has_key_dispenser) {
        this.eightd_has_key_dispenser = eightd_has_key_dispenser;
    }

    public boolean isHas_kiosk() {
        return has_kiosk;
    }

    public void setHas_kiosk(boolean has_kiosk) {
        this.has_kiosk = has_kiosk;
    }
}
