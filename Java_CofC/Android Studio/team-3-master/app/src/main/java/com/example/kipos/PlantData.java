package com.example.notificationtest;

public class PlantData {

    private String name;
    private String description;
    private int until_harvest;
    private int until_water;
    private int ph_preference;

    public PlantData(){
        name = "";
        description = "";
        until_harvest = 60;
        until_water = 2;
        ph_preference = 7;
    }

    public PlantData(String name, int until_harvest, int until_water){
        this.name = name;
        this.until_water = until_water;
        this.until_harvest = until_harvest;
    }

    public String getName() {
        return name;
    }

    public int getPH() {
        return ph_preference;
    }

    public int getUntilHarvest() {
        return until_harvest;
    }

    public int getUntilWater() {
        return until_water;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUntilWater(int until_water) {
        this.until_water = until_water;
    }

    public void setUntilHarvest(int until_harvest) {
        this.until_harvest = until_harvest;
    }

    public void setPH(int ph_preference) {
        this.ph_preference = ph_preference;
    }
}
