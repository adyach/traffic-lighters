package com.safetyculture.trafficlighter;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class RoundSwitchStrategyTest {

    @Test
    public void shouldRotateElements() {
        Queue<TrafficLighterContainer> queue = new LinkedList<>();
        TrafficLighterSet set1 = new TrafficLighterSet(10, 5, new TrafficLighter("A"));
        queue.add(set1);
        TrafficLighterSet set2 = new TrafficLighterSet(10, 5, new TrafficLighter("B"));
        queue.add(set2);
        RoundSwitchStrategy strategy = new RoundSwitchStrategy(queue);

        Assert.assertEquals(set1.hashCode(), strategy.next().hashCode());
        Assert.assertEquals(set2.hashCode(), strategy.next().hashCode());
        Assert.assertEquals(set1.hashCode(), strategy.next().hashCode());
        Assert.assertEquals(set2.hashCode(), strategy.next().hashCode());
    }

}