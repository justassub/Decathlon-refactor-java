import model.Athlete;
import model.AthleteFactory;
import org.junit.Assert;
import org.junit.Test;
import service.PlayerScoreCalculator;

import java.util.Arrays;
import java.util.List;

public class ScoreCalculatorTest {
    @Test
    public void calculateCorrectlyPoi() {
        List<Athlete> athleteList = Arrays.asList(
                AthleteFactory.buildFromResult("First Place;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72"),
                AthleteFactory.buildFromResult("Second Place;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75"),
                AthleteFactory.buildFromResult("Second Place Two;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75"),
                AthleteFactory.buildFromResult("Fourth Place;13.85;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75")
        );
        PlayerScoreCalculator scoreCalculator = new PlayerScoreCalculator(athleteList);
        scoreCalculator.calculateScores();
        scoreCalculator.rankPlayers();

        Athlete first = athleteList.stream().filter(athlete -> "First Place".equals(athlete.getFullName())).findFirst().get();
        Athlete secondOne = athleteList.stream().filter(athlete -> "Second Place".equals(athlete.getFullName())).findFirst().get();
        Athlete secondTwo = athleteList.stream().filter(athlete -> "Second Place Two".equals(athlete.getFullName())).findFirst().get();
        Athlete fourth = athleteList.stream().filter(athlete -> "Fourth Place".equals(athlete.getFullName())).findFirst().get();

        Assert.assertTrue(first.getPlace() == 1);
        Assert.assertTrue(secondOne.getPlace() == 2);
        Assert.assertTrue(secondTwo.getPlace() == 2);
        Assert.assertTrue(fourth.getPlace() == 4);


    }


}
