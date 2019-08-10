package com.what2drive.message_protocol;

import com.google.gson.GsonBuilder;

import java.util.Objects;

public class Car implements JsonSerializable {
    private String make;
    private String model;
    private String generation;
    private String body;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public Car(String make, String model, String generation, String body) {
        this.make = make;
        this.model = model;
        this.generation = generation;
        this.body = body;
    }

    public Car(Car car) {
        this(car.getMake(), car.getModel(), car.getGeneration(), car.getBody());
    }

    public Car(String json) {
        this(fromJson(json));
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getGeneration() {
        return generation;
    }

    public String getBody() {
        return body;
    }
    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(generation, car.generation) && Objects.equals(body, car.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, generation, body);
    }

    @Override
    public String toString() {
        return "Car{make='" + make + "', model='" + model + "', generation='" + generation + "', body='" + body + "'}";
    }

    private static Car fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, Car.class);
    }
    //------------------------------------------------------------------------------------------------------------------
}