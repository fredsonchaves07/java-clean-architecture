package com.clean.architecture.domain.service;

import com.clean.architecture.domain.entities.Item;

public class FreightCalculator {

    public static Double calculate(Item item) {
        double freight = 1000 * item.getVolume() * (item.getDensity() / 100);
        return (freight < 10) ? 10 : freight;
    }
}
