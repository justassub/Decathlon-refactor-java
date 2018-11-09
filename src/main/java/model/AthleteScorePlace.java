package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AthleteScorePlace {
    private final String name;
    @Setter
    private int place;
    private final double scores;

    public AthleteScorePlace(String name, double scores) {
        this.name = name;
        this.scores = scores;
    }
}
