package service;


import lombok.Value;
import model.Athlete;

import java.util.List;

import static java.util.Comparator.comparingInt;
import static model.Event.*;
import static service.EventPointCalculatorService.*;

@Value
public class PlayerScoreCalculator {
    List<Athlete> athletes;

    public PlayerScoreCalculator(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public void calculateScores() {
        athletes.forEach(this::calculateAndSetTotalPoints);
    }

    private void sortListByScores() {
        athletes.sort(comparingInt(Athlete::getScores).reversed());
    }

    public void rankPlayers() {
        sortListByScores();
        int[] scorePoints = {0};
        int[] takenPlace = {0};
        int[] number = {0};
        for (Athlete athlete : athletes) {
            ++number[0];
            //in case of same score- they share same place.
            if (scorePoints[0] != athlete.getScores()) {
                scorePoints[0] = athlete.getScores();
                takenPlace[0] = number[0];
            }
            athlete.setPlace(takenPlace[0]);
        }
    }

    private void calculateAndSetTotalPoints(Athlete athlete) {
        int scores = 0;

        scores += calculateTrackingEventScore(HUNDRED_METERS, athlete.getRunning_100_meters());
        scores += calculateTrackingEventScore(HURDLE, athlete.getRunning_110_hurdles());
        scores += calculateTrackingEventScore(FOUR_HUNDRED_METERS, athlete.getRunning_400_meters());
        scores += calculateTrackingEventScore(KILOMETER_AND_HALF, athlete.getRunning_1500_meters());

        scores += calculateThrowEventScore(DISCUS_THROW, athlete.getDiscus_throw_meters());
        scores += calculateThrowEventScore(JAVELIN_THROW, athlete.getJavelin_throw_meters());
        scores += calculateThrowEventScore(SHOT_PUT, athlete.getShot_put_meters());

        scores += calculateJumpEventScore(HIGH_JUMP, athlete.getHigh_jump_meters());
        scores += calculateJumpEventScore(LONG_JUMP, athlete.getLong_jump_meters());
        scores += calculateJumpEventScore(POLE_VAULT, athlete.getPole_vault_meters());

        athlete.setScores(scores);
    }
}
