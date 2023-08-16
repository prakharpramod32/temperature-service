package com.demo.temperature.kafka;

import com.demo.temperature.model.TemperatureEvent;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TemperatureEventSerializer implements Serializer<TemperatureEvent> {
    @Override
    public byte[] serialize(String s, TemperatureEvent temperatureEvent) {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(temperatureEvent);
            objectStream.flush();
            return byteStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error serializing TemperatureEvent", e);
        }
    }
}

