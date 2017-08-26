package com.safetyculture.trafficlighter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputActivityTrackerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldStartTrackingRightAwayWhenStartTrackingIs0() {
        LighterActivityTracker tracker = new OutputActivityTracker(0, 1);
        tracker.track(new TrafficLighter("A"), TrafficLighter.Light.GREEN);
        Assert.assertTrue(out.toString().matches(".* A RED -> GREEN\n"));
    }

    @Test
    public void shouldTrackFor1MinWhenIntervalIs1Min() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LighterActivityTracker tracker = new OutputActivityTracker(0, 1);
        tracker.track(new TrafficLighter("A"), TrafficLighter.Light.GREEN);
        Assert.assertTrue(outContent.toString().matches(".* A RED -> GREEN\n"));
        outContent.reset();

        long finishAt = System.currentTimeMillis() + 1000 * 61;
        while (System.currentTimeMillis() - finishAt < 0) {
            Thread.sleep(1000);
        }

        tracker.track(new TrafficLighter("A"), TrafficLighter.Light.RED);
        Assert.assertTrue(outContent.toString().isEmpty());
    }
}