package menu.io.coach;

import menu.io.InputReader;

import java.util.Arrays;
import java.util.List;

public class CoachNameReader {
    private static final String DELIMITER = ",";
    private static final String PROMPT = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private final InputReader reader;

    public CoachNameReader(InputReader reader) {
        this.reader = reader;
    }

    public CoachNames read() {
        System.out.println(PROMPT);
        return new CoachNames(readNames());
    }

    private List<String> readNames() {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toList();
    }
}
