package model;

import competition.fieldEvents.*;
import competition.trackingEvents.Running100Meters;
import competition.trackingEvents.Running110Hurdles;
import competition.trackingEvents.Running1500Meters;
import competition.trackingEvents.Running400Meters;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
public class Athlete {
    private  String fullName;
    private  Duration running_100_meters;
    private  double long_jump_meters;
    private  double shot_put_meters;
    private  double high_jump_meters;
    private  Duration running_400_meters;
    private  Duration running_110_hurdles;
    private  double discus_throw_meters;
    private  double pole_vault_meters;
    private  double javelin_throw_meters;
    private  Duration running_1500_meters;
    private int scores;
    private int place;


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
