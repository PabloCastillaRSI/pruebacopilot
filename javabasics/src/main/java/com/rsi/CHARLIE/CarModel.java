package com.rsi.CHARLIE;

public class CarModel {
    private String brand;
    private String model;
    private int year;
    private String engineType;
    private double price;

    public CarModel(String brand, String model, int year, String engineType, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
public String toString() {
    return String.format("Brand: %s\nModel: %s\nYear: %d\nEngine Type: %s\nPrice: $%.2f",
            brand, model, year, engineType, price);
}
}
