import model.Athlete;
import service.FileReaderService;
import service.ScoreCalculator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static Stream<Path> filesToRead = Stream.of(
            Paths.get("./src/main/resources/input.txt")
    );
    private static List<Athlete> athletes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        loadAthletes();
        calculateRankings();
    }

    private static void loadAthletes() {
        filesToRead
                .map(FileReaderService::readFile)
                .flatMap(stringStream -> stringStream)
                .map(Athlete::new)
                .forEach(athletes::add);
    }

    private static void calculateRankings() {
        ScoreCalculator scoreCalculator = new ScoreCalculator(athletes);
        scoreCalculator.calculateScores();
        scoreCalculator.rankPlayers();
    }
}
