package com.safetyculture.trafficlighter;

/**
 * Represents container for grouped traffic lighters.
 */
public interface TrafficLighterContainer {
    public void setTrafficLight(TrafficLighter.Light light, LighterActivityTracker tracker);

    public long getSwitchTime();

    public long getYellowTime();

    public int size();
}
