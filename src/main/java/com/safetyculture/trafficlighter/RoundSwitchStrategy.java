package com.safetyculture.trafficlighter;

import java.util.Queue;

/**
 * Represents simple implementation, which takes the next pair of traffic lighters in circle.
 */
public class RoundSwitchStrategy implements LighterSwitchStrategy {
    private final Queue<TrafficLighterContainer> trafficLighters;

    public RoundSwitchStrategy(Queue<TrafficLighterContainer> trafficLighters) {
        this.trafficLighters = trafficLighters;
    }

    @Override
    public TrafficLighterContainer next() {
        TrafficLighterContainer set = trafficLighters.poll();
        trafficLighters.offer(set);
        return set;
    }
}
