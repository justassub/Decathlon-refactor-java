package competitionTest;

import competition.Event;
import competition.Running100Meters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RunningTest {
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
