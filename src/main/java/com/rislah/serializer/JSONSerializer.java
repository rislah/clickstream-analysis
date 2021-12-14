package com.rislah.serializer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class JSONSerializer<T> implements Serializer<T> {
    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    @Override
    public byte[] serialize(String topic, T data) {
        if (data == null)
            return null;
        return gson.toJson(data).getBytes();
    }
}
