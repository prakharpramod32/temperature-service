package com.demo.temperature.service;

import com.demo.temperature.kafka.KafkaEventProducer;
import com.demo.temperature.model.Event;
import com.demo.temperature.model.Temperature;
import com.demo.temperature.model.TemperatureEvent;
import com.demo.temperature.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;
    @Autowired
    private KafkaEventProducer kafkaEventProducer;

    public Temperature createTemperature(Temperature temperature) {
        validateTemperature(temperature);
        return temperatureRepository.save(temperature);
    }

    private void validateTemperature(Temperature temperature) {
        if (temperature.getParameter().getValue() < temperature.getParameter().getMinValue() ||
                temperature.getParameter().getValue() > temperature.getParameter().getMaxValue()) {
            TemperatureEvent temperatureEvent = createEvent("OUT_OF_RANGE", "Temperature value is beyond limits", temperature);
            kafkaEventProducer.sendEvent(temperatureEvent);
        }
    }

    private TemperatureEvent createEvent(String eventType, String description, Temperature temperature) {
        Event event = Event.builder()
                .eventType(eventType)
                .description(description)
                .build();

        return TemperatureEvent.builder()
                .temperature(temperature)
                .event(event)
                .build();
    }

    public Temperature getTemperature(String resourceId) {
        return temperatureRepository.findByResourceId(resourceId).orElse(null);
    }
}
