package com.demo.temperature.controller;

import com.demo.temperature.model.Temperature;
import com.demo.temperature.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @PostMapping("/createTemperature")
    public Temperature createTemperature(@RequestBody Temperature temperature) {
        return temperatureService.createTemperature(temperature);
    }

    @GetMapping("/getTemperature/{resourceId}")
    public Temperature getTemperature(@PathVariable String resourceId) {
        return temperatureService.getTemperature(resourceId);
    }
}
