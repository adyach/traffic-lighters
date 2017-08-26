package com.safetyculture.trafficlighter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents simple implementation, which prints every record in specified period of time to out stream.
 */
public class OutputActivityTracker implements LighterActivityTracker {
    // start time of the app
    private final long startTime;
    // from which minute start tracking
    private final long whenStartedTracking;
    // for how long should we track
    private final long intervalMin;

    public OutputActivityTracker(long whenStartTracking, long intervalMin) {
        this.whenStartedTracking = TimeUnit.MILLISECONDS.convert(whenStartTracking, TimeUnit.MINUTES);
        this.startTime = System.currentTimeMillis();
        this.intervalMin = TimeUnit.MILLISECONDS.convert(intervalMin, TimeUnit.MINUTES);
    }

    @Override
    public void track(TrafficLighter trafficLighter, TrafficLighter.Light light) {
        long elapsedTimeMin = System.currentTimeMillis() - startTime;
        if (elapsedTimeMin >= whenStartedTracking && elapsedTimeMin < whenStartedTracking + intervalMin) {
            System.out.println(new StringBuilder().append(new Date()).append(" ")
                    .append(trafficLighter.getId()).append(" ")
                    .append(trafficLighter.getLight()).append(" -> ").append(light));
        }
    }

}
