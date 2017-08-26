package com.safetyculture.trafficlighter;

/**
 * Represents abstraction on top of the tracker implementations.
 */
public interface LighterActivityTracker {
    public void track(TrafficLighter trafficLighter, TrafficLighter.Light light);
}
