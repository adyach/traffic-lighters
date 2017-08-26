package com.safetyculture.trafficlighter;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class TrafficLighterSetTest {

    @Test
    public void shouldGenerate4LightersWhenNumberOfLightersIs4() {
        TrafficLighterSet set = new TrafficLighterSet(4, 5, 10);
        Assert.assertEquals(4, set.size());
    }

    @Test
    public void shouldCreate2LightersWithYellowTime5AndSwitchTime10() {
        TrafficLighterSet set = new TrafficLighterSet(10, 5, new TrafficLighter("A"), new TrafficLighter("B"));
        Assert.assertEquals(2, set.size());
        Assert.assertEquals(5, set.getYellowTime());
        Assert.assertEquals(10, set.getSwitchTime());
    }

    @Test
    public void shouldSetTrafficLightsToGreen() {
        TrafficLighter[] trafficLighters = new TrafficLighter[]{new TrafficLighter("A"), new TrafficLighter("B")};
        TrafficLighterSet set = new TrafficLighterSet(10, 5, trafficLighters);
        set.setTrafficLight(TrafficLighter.Light.GREEN, (trafficLighter, light) -> {});
        Stream.of(trafficLighters).forEach(trafficLighter -> Assert.assertEquals(TrafficLighter.Light.GREEN, trafficLighter.getLight()));
    }

}