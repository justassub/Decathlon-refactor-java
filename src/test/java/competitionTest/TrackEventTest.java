package competitionTest;

import competition.*;
import competition.fieldEvents.JavelinThrowEvent;
import competition.trackingEvents.Running100Meters;
import competition.trackingEvents.Running110Hurdles;
import competition.trackingEvents.Running1500Meters;
import competition.trackingEvents.Running400Meters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TrackEventTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new Running100Meters(),
                        "PT11.4S",
                        774
                },
                {
                        new Running100Meters(),
                        "PT10.4S",
                        999
                },
                {
                        new Running100Meters(),
                        "PT10.04S",
                        1086
                },
                {
                        new Running400Meters(),
                        "PT55.04S",
                        597
                },
                {
                        new Running400Meters(),
                        "PT10S",
                        3537
                },
                {
                        new Running400Meters(),
                        "PT10.5S",
                        3492
                },
                {
                        new Running110Hurdles(),
                        "PT15S",
                        850
                },
                {
                        new Running110Hurdles(),
                        "PT15.2S",
                        825
                },
                {
                        new Running110Hurdles(),
                        "PT0S",
                        3568
                },
                {
                        new Running110Hurdles(),
                        "PT29S",
                        0
                },
                {
                        new Running1500Meters(),
                        "PT0S",
                        3438
                },
                {
                        new Running1500Meters(),
                        "PT475S",
                        0
                },
                {
                        new Running1500Meters(),
                        "PT100S",
                        2232
                },
                {
                        new Running1500Meters(),
                        "PT100.05S",
                        2231
                },

        });
    }

    @Parameterized.Parameter
    public Event event;
    @Parameterized.Parameter(1)
    public String duration;
    @Parameterized.Parameter(2)
    public int expectedScores;

    @Test
    public void calculateRunningScores() {
        Assert.assertTrue(expectedScores == event.calculatePoints(Duration.parse(duration)));
    }
}
