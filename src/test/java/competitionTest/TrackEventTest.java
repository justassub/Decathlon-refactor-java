package competitionTest;

import model.Event;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static service.EventPointCalculatorService.calculateTrackingEventScore;

@RunWith(Parameterized.class)
public class TrackEventTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        calculateTrackingEventScore(Event.HUNDRED_METERS, Duration.parse("PT11.4S")),
                        774
                },
                {
                        calculateTrackingEventScore(Event.HUNDRED_METERS, Duration.parse("PT10.4S")),
                        999
                },
                {
                        calculateTrackingEventScore(Event.HUNDRED_METERS, Duration.parse("PT10.04S")),
                        1086
                },
                {
                        calculateTrackingEventScore(Event.FOUR_HUNDRED_METERS, Duration.parse("PT55.04S")),
                        597
                },
                {
                        calculateTrackingEventScore(Event.FOUR_HUNDRED_METERS, Duration.parse("PT10S")),
                        3537
                },
                {
                        calculateTrackingEventScore(Event.FOUR_HUNDRED_METERS, Duration.parse("PT10.5S")),
                        3492
                },
                {
                        calculateTrackingEventScore(Event.HURDLE, Duration.parse("PT15S")),
                        850
                },
                {
                        calculateTrackingEventScore(Event.HURDLE, Duration.parse("PT15.2S")),
                        825
                },
                {
                        calculateTrackingEventScore(Event.HURDLE, Duration.parse("PT0S")),
                        3568
                },
                {
                        calculateTrackingEventScore(Event.HURDLE, Duration.parse("PT29S")),
                        0
                },
                {
                        calculateTrackingEventScore(Event.KILOMETER_AND_HALF, Duration.parse("PT0S")),
                        3438
                },
                {
                        calculateTrackingEventScore(Event.KILOMETER_AND_HALF, Duration.parse("PT475S")),
                        0
                },
                {
                        calculateTrackingEventScore(Event.KILOMETER_AND_HALF, Duration.parse("PT100S")),
                        2232
                },
                {
                        calculateTrackingEventScore(Event.KILOMETER_AND_HALF, Duration.parse("PT100.05S")),
                        2231
                },

        });
    }

    @Parameterized.Parameter
    public double result;
    @Parameterized.Parameter(1)
    public int expectedScores;

    @Test
    public void calculateRunningScores() {
        Assert.assertTrue(result == expectedScores);
    }
}
