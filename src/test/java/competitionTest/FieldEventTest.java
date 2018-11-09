package competitionTest;

import competition.Event;
import competition.fieldEvents.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FieldEventTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new LongJumpEvent(),
                        8,
                        1061
                },
                {
                        new LongJumpEvent(),
                        2.5,
                        16
                },
                {
                        new HighJumpEvent(),
                        1,
                        81
                },
                {
                        new HighJumpEvent(),
                        5,
                        4570
                },
                {
                        new ShotPutEvent(),
                        18.4,
                        1000
                },
                {
                        new ShotPutEvent(),
                        15,
                        790
                },
                {
                        new DiscusThrowEvent(),
                        15,
                        180
                },
                {
                        new DiscusThrowEvent(),
                        60.5,
                        1091
                },
                {
                        new PoleVaultEvent(),
                        5,
                        910
                },
                {
                        new PoleVaultEvent(),
                        5.9,
                        1198
                },
                {
                        new JavelinThrowEvent(),
                        100,
                        1355
                },
                {
                        new JavelinThrowEvent(),
                        50.5,
                        596
                },
        });
    }

    @Parameterized.Parameter
    public Event event;
    @Parameterized.Parameter(1)
    public double scores;
    @Parameterized.Parameter(2)
    public int expectedScores;

    @Test
    public void testFieldEvents() {
        Assert.assertTrue(event.calculatePoints(scores) == expectedScores);
    }
}
