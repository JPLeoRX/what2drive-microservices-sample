package com.what2drive.car_service.persistence;

import com.what2drive.car_service.CarId;
import com.what2drive.service_common.entities.DatabaseObject;
import com.what2drive.service_common.utils.Arguments;

import javax.persistence.*;

@Entity @Access(AccessType.FIELD) @Table(name = "car")
public class CarDO implements DatabaseObject<CarId> {
    @Id @Column(name = "id") private String id;
    @Column(name = "make") private String make;
    @Column(name = "model") private String model;
    @Column(name = "generation") private String generation;
    @Column(name = "body") private String body;
    @Column(name = "created_at") private long createdAt;
    @Column(name = "updated_at") private long updatedAt;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public CarDO() {

    }

    public CarDO(String id, String make, String model, String generation, String body, long createdAt, long updatedAt) {
        Arguments.checkForNull(id, make, model, generation, body, createdAt, updatedAt);

        this.id = id;
        this.make = make;
        this.model = model;
        this.generation = generation;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String getId() {
        return id;
    }

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

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }
    //------------------------------------------------------------------------------------------------------------------
}