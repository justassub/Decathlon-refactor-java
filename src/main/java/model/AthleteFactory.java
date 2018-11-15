package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class AthleteFactory {
    public static Athlete buildFromResult(String resultLine) {
        String[] results = resultLine.split(";");
        if (results.length != 11) {
            return null;
        }
        return Athlete.builder()
                .fullName(results[0])
                .running_100_meters(calculateDurationFromDouble(results[1]))
                .running_400_meters(calculateDurationFromDouble(results[5]))
                .running_110_hurdles(calculateDurationFromDouble(results[6]))
                .running_1500_meters(calculateRunning1500Time(results[10]))
                .long_jump_meters(Double.parseDouble(results[2]))
                .shot_put_meters(Double.parseDouble(results[3]))
                .high_jump_meters(Double.parseDouble(results[4]))
                .discus_throw_meters(Double.parseDouble(results[7]))
                .pole_vault_meters(Double.parseDouble(results[8]))
                .javelin_throw_meters(Double.parseDouble(results[9]))
                .build();
    }

    private static Duration calculateDurationFromDouble(String result) {
        Double time = Double.parseDouble(result);

        BigDecimal bd = new BigDecimal((time - Math.floor(time)) * 1000);
        return Duration.ofSeconds(time.intValue())
                .plusMillis(bd.setScale(0, RoundingMode.HALF_DOWN).intValue());
    }

    private static Duration calculateRunning1500Time(String time) {
        String[] splitedTime = time.split("\\.");
        return Duration.ofMinutes(Long.parseLong(splitedTime[0]))
                .plusSeconds(Long.parseLong(splitedTime[1]))
                .plusMillis(Long.parseLong(splitedTime[2]) * 10);
    }


}
