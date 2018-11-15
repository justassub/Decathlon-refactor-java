package competition.trackingEvents;

import competition.EventPointCalculator;
import model.Event;

public class EventPointCalculatorService {
    private static EventPointCalculator trackingEventPointCalculator = (aParam, bParam, cParam, result) ->
            (int) (aParam * Math.pow((bParam - result), cParam));
    private static EventPointCalculator throwingEventPointCalculator = (aParam, bParam, cParam, result) ->
            (int) (aParam * Math.pow((result - bParam), cParam));

    public static int calculateTrackingEventScore(Event e, double result) {
        return trackingEventPointCalculator.calculate(e.getAParameter(), e.getBParameter(), e.getCParameter(), result);
    }

    public static int calculateThrowEventScore(Event e, double result) {
        return throwingEventPointCalculator.calculate(e.getAParameter(), e.getBParameter(), e.getCParameter(), result);
    }

    public static int calculateJumpEventScore(Event e, double result) {
        return calculateThrowEventScore(e, result * 100);
    }
}
