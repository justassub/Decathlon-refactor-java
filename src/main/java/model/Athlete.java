package model;

import competition.fieldEvents.*;
import competition.trackingEvents.Running100Meters;
import competition.trackingEvents.Running110Hurdles;
import competition.trackingEvents.Running1500Meters;
import competition.trackingEvents.Running400Meters;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@ToString
public class Athlete {
    private final String fullName;
    private final Duration running_100_meters;
    private final double long_jump_meters;
    private final double shot_put_meters;
    private final double high_jump_meters;
    private final Duration running_400_meters;
    private final Duration running_110_hurdles;
    private final double discus_throw_meters;
    private final double pole_vault_meters;
    private final double javelin_throw_meters;
    private final Duration running_1500_meters;
    private int scores;
    private int place;

    public Athlete(String resultLine) {
        String[] splitedResults = resultLine.split(";");
        fullName = splitedResults[0];
        running_1500_meters = calculateRunning1500Time(splitedResults[10]);

        List<Double> resultsList = convertScoresToDouble(splitedResults);

        running_100_meters = calculateDurationFromDouble(resultsList.get(0));
        long_jump_meters = resultsList.get(1);
        shot_put_meters = resultsList.get(2);
        high_jump_meters = resultsList.get(3);
        running_400_meters = calculateDurationFromDouble(resultsList.get(4));
        running_110_hurdles = calculateDurationFromDouble(resultsList.get(5));
        discus_throw_meters = resultsList.get(6);
        pole_vault_meters = resultsList.get(7);
        javelin_throw_meters = resultsList.get(8);
    }

    private List<Double> convertScoresToDouble(String[] resultsArray) {
        List<String> results = new LinkedList<>(Arrays.asList(resultsArray));
        results.remove(0);  //remove name
        results.remove(9); //remove running_1500_meters result;
        return results.stream()
                .map(Double::valueOf)
                .collect(toList());
    }

    private Duration calculateDurationFromDouble(Double time) {
        BigDecimal bd = new BigDecimal((time - Math.floor(time)) * 1000);
        return Duration.ofSeconds(time.intValue())
                .plusMillis(bd.setScale(0, RoundingMode.HALF_DOWN).intValue());
    }

    private Duration calculateRunning1500Time(String time) {
        String[] splitedTime = time.split("\\.");
        return Duration.ofMinutes(Long.parseLong(splitedTime[0]))
                .plusSeconds(Long.parseLong(splitedTime[1]))
                .plusMillis(Long.parseLong(splitedTime[2]) * 10);
    }

    public void calculateTotalScore() {
        int scores = 0;
        scores += new Running100Meters().calculatePoints(running_100_meters);
        scores += new Running110Hurdles().calculatePoints(running_110_hurdles);
        scores += new Running400Meters().calculatePoints(running_400_meters);
        scores += new Running1500Meters().calculatePoints(running_1500_meters);

        scores += new DiscusThrowEvent().calculatePoints(discus_throw_meters);
        scores += new JavelinThrowEvent().calculatePoints(javelin_throw_meters);
        scores += new PoleVaultEvent().calculatePoints(pole_vault_meters);
        scores += new ShotPutEvent().calculatePoints(shot_put_meters);

        scores += new HighJumpEvent().calculatePoints(high_jump_meters);
        scores += new LongJumpEvent().calculatePoints(long_jump_meters);

        this.scores = scores;
    }

    public void setPlace(int place) {
        this.place = place;
    }


}
