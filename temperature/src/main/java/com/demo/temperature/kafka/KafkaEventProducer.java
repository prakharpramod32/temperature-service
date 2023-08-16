package com.demo.temperature.kafka;

import com.demo.temperature.model.TemperatureEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventProducer {

    @Autowired
    private KafkaTemplate<String, TemperatureEvent> kafkaTemplate;

    public void sendEvent(TemperatureEvent temperatureEvent) {
        kafkaTemplate.send("eventTopic", temperatureEvent);
    }
}
