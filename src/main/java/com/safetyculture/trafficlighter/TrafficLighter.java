package com.safetyculture.trafficlighter;

import java.util.UUID;

public class TrafficLighter {

    private final String id;
    private Light light;

    public TrafficLighter(String id) {
        this.id = id;
        this.light = Light.RED;
    }

    public TrafficLighter() {
        this.id = UUID.randomUUID().toString();
        this.light = Light.RED;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrafficLighter{");
        sb.append("id='").append(id).append('\'');
        sb.append(", light=").append(light);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public Light getLight() {
        return light;
    }

    public enum Light {
        GREEN, YELLOW, RED
    }

}
