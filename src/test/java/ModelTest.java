import model.Athlete;
import model.AthleteFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import service.PlayerScoreCalculator;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ModelTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72",
                        "Siim Susi",
                        createDurationFromString("PT12.61S"),
                        5.00,
                        9.22,
                        1.50,
                        createDurationFromString("PT60.39S"),
                        createDurationFromString("PT16.43S"),
                        21.60,
                        2.60,
                        35.81,
                        createDurationFromString("PT5M25.72S"),
                        4200
                },
                {
                        "Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75",
                        "Jaana Lind",
                        createDurationFromString("PT13.75S"),
                        4.84,
                        10.12,
                        1.50,
                        createDurationFromString("PT68.44S"),
                        createDurationFromString("PT19.18S"),
                        30.85,
                        2.80,
                        33.88,
                        createDurationFromString("PT6M22.75S"),
                        3494
                },
        });
    }

    @Parameter
    public String resultLine;
    @Parameter(1)
    public String expectedName;
    @Parameter(2)
    public Duration result100M;
    @Parameter(3)
    public double resultLongJump;
    @Parameter(4)
    public double resultShotPut;
    @Parameter(5)
    public double resultHighJump;
    @Parameter(6)
    public Duration running400M;
    @Parameter(7)
    public Duration running110M;
    @Parameter(8)
    public double discusThrow;
    @Parameter(9)
    public double poleVault;
    @Parameter(10)
    public double javelinThrow;
    @Parameter(11)
    public Duration running1500M;
    @Parameter(12)
    public int totalScores;

    @Test
    public void modelTests() {
        Athlete athlete = AthleteFactory.buildFromResult(resultLine);
        new PlayerScoreCalculator(Arrays.asList(athlete)).calculateScores();
        Assert.assertEquals(athlete.getFullName(), expectedName);
        Assert.assertEquals(athlete.getRunning_100_meters(), result100M);
        Assert.assertEquals(athlete.getLong_jump_meters(), resultLongJump, 0.001);
        Assert.assertEquals(athlete.getShot_put_meters(), resultShotPut, 0.001);
        Assert.assertEquals(athlete.getHigh_jump_meters(), resultHighJump, 0.001);
        Assert.assertEquals(athlete.getRunning_400_meters(), running400M);
        Assert.assertEquals(athlete.getRunning_110_hurdles(), running110M);
        Assert.assertEquals(athlete.getDiscus_throw_meters(), discusThrow, 0.001);
        Assert.assertEquals(athlete.getPole_vault_meters(), poleVault, 0.001);
        Assert.assertEquals(athlete.getJavelin_throw_meters(), javelinThrow, 0.001);
        Assert.assertEquals(athlete.getRunning_1500_meters(), running1500M);
        Assert.assertTrue(athlete.getScores() == totalScores);
    }

    private static Duration createDurationFromString(String durationString) {
        return Duration.parse(durationString);
    }


}
