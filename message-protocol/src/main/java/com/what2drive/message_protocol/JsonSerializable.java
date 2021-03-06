package com.what2drive.message_protocol;

import com.google.gson.GsonBuilder;

import java.io.Serializable;

public interface JsonSerializable extends Serializable {
    default String toJson() {
        return new GsonBuilder().create().toJson(this);
    }
}