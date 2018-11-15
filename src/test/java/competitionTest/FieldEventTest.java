package competitionTest;

import model.Event;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static service.EventPointCalculatorService.calculateJumpEventScore;
import static service.EventPointCalculatorService.calculateThrowEventScore;

@RunWith(Parameterized.class)
public class FieldEventTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        calculateJumpEventScore(Event.POLE_VAULT, 5),
                        910
                },
                {
                        calculateJumpEventScore(model.Event.LONG_JUMP, 8),
                        1061
                },
                {
                        calculateJumpEventScore(Event.HIGH_JUMP, 1.0),
                        81
                },
                {
                        calculateThrowEventScore(Event.SHOT_PUT, 18.4),
                        1000
                },

                {
                        calculateThrowEventScore(Event.DISCUS_THROW, 15),
                        180
                },
                {
                        calculateThrowEventScore(Event.JAVELIN_THROW, 100.0),
                        1355
                },
        });
    }

    @Parameterized.Parameter
    public double result;
    @Parameterized.Parameter(1)
    public int expectedScores;

    @Test
    public void testFieldEvents() {
        Assert.assertTrue(result == expectedScores);
    }
}
