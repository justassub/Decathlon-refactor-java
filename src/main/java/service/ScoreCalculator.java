package service;

import lombok.Value;
import model.Athlete;

import java.util.List;

import static java.util.Comparator.comparingInt;

@Value
public class ScoreCalculator {
    List<Athlete> athletes;

    public ScoreCalculator(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public void calculateScores() {
        athletes.forEach(Athlete::calculateTotalScore);
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
}
