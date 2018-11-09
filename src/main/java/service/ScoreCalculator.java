package service;

import lombok.Value;
import model.Athlete;

import java.util.List;
@Value
public class ScoreCalculator {
    List<Athlete> athletes;

    public ScoreCalculator(List<Athlete> athletes) {
        this.athletes = athletes;
    }
    public void calculate(){
        athletes.forEach(athlete -> {

        });
    }
}
