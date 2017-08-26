package com.safetyculture.trafficlighter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * The main class represents the intersection where traffic lighters are set up.
 */
public class Intersection {

    private static final long TIME_SWITCH = TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES);
    private static final long TIME_YELLOW = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
    // for how long should we track
    private static final long TIME_TRACKING_INTERVAL = 30;
    private static long whenStartTracking;

    /**
     * Runs the system.
     *
     * @param args - the 0 element represent from which minute start tracking (counts from the app start), default 0
     */
    public static void main(String[] args) {
        Queue<TrafficLighterContainer> trafficLighters = new LinkedList<>();
        trafficLighters.add(new TrafficLighterSet(TIME_SWITCH, TIME_YELLOW, new TrafficLighter("S"), new TrafficLighter("N")));
        trafficLighters.add(new TrafficLighterSet(TIME_SWITCH, TIME_YELLOW, new TrafficLighter("E"), new TrafficLighter("W")));

        OutputActivityTracker outputActivityTracker = new OutputActivityTracker(getWhenStartTracking(args), TIME_TRACKING_INTERVAL);
        RoundSwitchStrategy roundSwitchStrategy = new RoundSwitchStrategy(trafficLighters);

        TrafficLightController controller = new TrafficLightController(roundSwitchStrategy, outputActivityTracker);
        while (true) {
            try {
                controller.controlLights();
            } catch (Throwable th) {
                System.err.println("Ups. Code carefully. Reinitializing ...");
            }
        }
    }

    private static long getWhenStartTracking(String[] args) {
        if (args.length == 0) {
            return 0;
        }
        return Long.valueOf(args[0]).longValue();
    }
}
