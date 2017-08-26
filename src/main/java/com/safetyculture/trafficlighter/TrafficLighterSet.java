package com.safetyculture.trafficlighter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents the list of working together traffic lighters.
 */
public class TrafficLighterSet implements TrafficLighterContainer {

    private final Set<TrafficLighter> trafficLighters;
    private final long switchTime;
    private final long yellowTime;

    public TrafficLighterSet(int trafficLightersNum, long switchTime, long yellowTime) {
        this.trafficLighters = Stream.generate(() -> new TrafficLighter())
                .limit(trafficLightersNum)
                .collect(Collectors.toSet());
        this.switchTime = switchTime;
        this.yellowTime = yellowTime;
    }

    public TrafficLighterSet(long switchTime, long yellowTime, TrafficLighter ... lighters) {
        this.trafficLighters = Stream.of(lighters).collect(Collectors.toSet());
        this.switchTime = switchTime;
        this.yellowTime = yellowTime;
    }

    @Override
    public void setTrafficLight(TrafficLighter.Light light, LighterActivityTracker tracker) {
        trafficLighters.forEach(trafficLighter -> {
            tracker.track(trafficLighter, light);
            trafficLighter.setLight(light);
        });
    }

    @Override
    public long getSwitchTime() {
        return switchTime;
    }

    @Override
    public long getYellowTime() {
        return yellowTime;
    }

    @Override
    public int size() {
        return trafficLighters.size();
    }

    @Override
    public String toString() {
        return new StringBuilder().append(trafficLighters).toString();
    }
}
