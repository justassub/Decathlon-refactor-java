import model.Athlete;
import model.AthleteFactory;
import service.FileReaderService;
import service.PlayerScoreCalculator;

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
                .parallel()
                .map(AthleteFactory::buildFromResult)
                .filter(Main::checkIfAthleteIsNotNull)
                .forEach(athletes::add);
    }

    private static void calculateRankings() {
        PlayerScoreCalculator scoreCalculator = new PlayerScoreCalculator(athletes);
        scoreCalculator.calculateScores();
        scoreCalculator.rankPlayers();
    }

    public static boolean checkIfAthleteIsNotNull(Athlete athlete) {
        return athlete != null;
    }
}
