package menu.io.coach;

import menu.io.InputReader;

import java.util.Arrays;
import java.util.List;

public class NonPreferredFoodReader {
    private static final String DELIMITER = ",";
    private static final String PROMPT_TEMPLATE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private final InputReader reader;

    public NonPreferredFoodReader(InputReader reader) {
        this.reader = reader;
    }

    public NonPreferredFoods read(String coachName) {
        System.out.println(PROMPT_TEMPLATE.formatted(coachName));
        return new NonPreferredFoods(
                readNonPreferredFoods());
    }

    private List<String> readNonPreferredFoods() {
        return Arrays.stream(reader.readLine().split(DELIMITER)).toList();
    }
}
