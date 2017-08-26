package com.safetyculture.trafficlighter;

/**
 * Represents traffic lights controller, which coordinated basic features of the traffic lighters at the intersection.
 */
public class TrafficLightController {

    private final LighterSwitchStrategy lighterSwitchStrategy;
    private final LighterActivityTracker lighterActivityTracker;

    public TrafficLightController(LighterSwitchStrategy lighterSwitchStrategy, LighterActivityTracker lighterActivityTracker) {
        this.lighterSwitchStrategy = lighterSwitchStrategy;
        this.lighterActivityTracker = lighterActivityTracker;
    }

    /**
     * Loops over the traffic lights and changes the lights.
     */
    public void controlLights() throws InterruptedException {
        TrafficLighterContainer container = lighterSwitchStrategy.next();
        container.setTrafficLight(TrafficLighter.Light.GREEN, lighterActivityTracker);

        long finishAt = System.currentTimeMillis() + container.getSwitchTime();
        while (System.currentTimeMillis() - finishAt < 0) {
            Thread.sleep(1000);
        }
        container.setTrafficLight(TrafficLighter.Light.YELLOW, lighterActivityTracker);

        finishAt = System.currentTimeMillis() + container.getYellowTime();
        while (System.currentTimeMillis() - finishAt < 0) {
            Thread.sleep(1000);
        }
        container.setTrafficLight(TrafficLighter.Light.RED, lighterActivityTracker);
    }

}
