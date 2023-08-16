package com.demo.temperature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter implements Serializable {

    private String key;
    private int value;
    private int minValue;
    private int maxValue;
}
