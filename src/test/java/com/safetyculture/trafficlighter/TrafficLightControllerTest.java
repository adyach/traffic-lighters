package com.safetyculture.trafficlighter;

import org.junit.Assert;
import org.junit.Test;

public class TrafficLightControllerTest {

    @Test
    public void testControlLights() throws Exception {
        TrafficLightController controller = new TrafficLightController(() -> new TestTrafficLighterContainer(), (trafficLighter, light) -> {});
        controller.controlLights();
    }

    private static class TestTrafficLighterContainer implements TrafficLighterContainer {

        private int counter;

        @Override
        public void setTrafficLight(TrafficLighter.Light light, LighterActivityTracker tracker) {
            if (counter == 0) {
                Assert.assertEquals(TrafficLighter.Light.GREEN, light);
            }

            if (counter == 1) {
                Assert.assertEquals(TrafficLighter.Light.YELLOW, light);
            }

            if (counter == 2) {
                Assert.assertEquals(TrafficLighter.Light.RED, light);
            }

            counter++;
        }

        @Override
        public long getSwitchTime() {
            return 2;
        }

        @Override
        public long getYellowTime() {
            return 1;
        }

        @Override
        public int size() {
            return 1;
        }
    }
}