package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReaderService {
    public static Stream<String> readFile(Path file) {
        try {
            return Files.lines(file);
        } catch (Exception anyException) {
            System.out.println(String.format("Something went wrong: %s", anyException.getMessage()));
            return Stream.empty();
        }
    }
}
