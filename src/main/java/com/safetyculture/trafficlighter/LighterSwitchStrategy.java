package com.safetyculture.trafficlighter;

/**
 * Represents interface for different behaviour of choosing the next traffic lighters to switch lights.
 * Could be useful if intersection has more than 4 traffic lighters.
 */
public interface LighterSwitchStrategy {
    public TrafficLighterContainer next();
}
