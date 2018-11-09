package model;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Value
public class Athlete {
    private String fullName;
    private Duration running_100_meters;
    private double long_jump_meters;
    private double shot_put_meters;
    private double high_jump_meters;
    private Duration running_400;
    private Duration running_110_hurdles;
    private double discus_throw_meters;
    private double pole_vault_meters;
    private double javelin_throw_meters;
    private Duration running_1500_meters;

    public Athlete(String resultLine) {
        String[] splitedResults = resultLine.split(";");
        fullName = splitedResults[0];
        running_1500_meters = calculateRunning1500Time(splitedResults[10]);

        List<Double> resultsList = convertScoresToDouble(splitedResults);

        running_100_meters = calculateDurationFromDouble(resultsList.get(0));
        long_jump_meters = resultsList.get(1);
        shot_put_meters = resultsList.get(2);
        high_jump_meters = resultsList.get(3);
        running_400 = calculateDurationFromDouble(resultsList.get(4));
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

    public Duration calculateDurationFromDouble(Double time) {
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


}
