package model;

import lombok.Getter;

@Getter
public enum Event {
    HUNDRED_METERS(25.4347, 18, 1.81),
    LONG_JUMP(0.14354, 220, 1.4),
    SHOT_PUT(51.39, 1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42),
    FOUR_HUNDRED_METERS(1.53775, 82, 1.81),
    HURDLE(5.74352, 28.5, 1.92),
    DISCUS_THROW(12.91, 4, 1.1),
    POLE_VAULT(0.2797, 100, 1.35),
    JAVELIN_THROW(10.14, 7, 1.08),
    KILOMETER_AND_HALF(0.03768, 480, 1.85);

    private final double aParameter;
    private final double bParameter;
    private final double cParameter;


    Event(double aParam, double bParam, double cParam) {
        this.aParameter = aParam;
        this.bParameter = bParam;
        this.cParameter = cParam;
    }
}
