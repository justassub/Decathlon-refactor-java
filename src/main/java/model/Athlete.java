package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class Athlete {
    private String fullName;
    private Duration running_100_meters;
    private double long_jump_meters;
    private double shot_put_meters;
    private double high_jump_meters;
    private Duration running_400_meters;
    private Duration running_110_hurdles;
    private double discus_throw_meters;
    private double pole_vault_meters;
    private double javelin_throw_meters;
    private Duration running_1500_meters;
    private int scores;
    private int place;


    public void setPlace(int place) {
        this.place = place;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
