package menu.io.coach;

import menu.io.InputReader;

import java.util.Arrays;
import java.util.List;

public class CoachNameReader {
    private static final String DELIMITER = ",";

    private final InputReader reader;

    public CoachNameReader(InputReader reader) {
        this.reader = reader;
    }

    public CoachNames read() {
        return new CoachNames(readNames());
    }

    private List<String> readNames() {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toList();
    }
}
