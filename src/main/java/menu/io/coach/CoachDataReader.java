package menu.io.coach;

import java.util.LinkedList;
import java.util.List;

public class CoachDataReader {
    private static final String PROMPT = "점심 메뉴 추천을 시작합니다.";

    private final CoachNameReader nameReader;
    private final NonPreferredFoodReader nonPreferredFoodReader;

    public CoachDataReader(CoachNameReader nameReader, NonPreferredFoodReader nonPreferredFoodReader) {
        this.nameReader = nameReader;
        this.nonPreferredFoodReader = nonPreferredFoodReader;
    }

    public List<CoachData> read() {
        System.out.println(PROMPT);
        return readCoachData();
    }

    private List<CoachData> readCoachData() {
        List<CoachData> result = new LinkedList<>();
        CoachNames names = nameReader.read();
        for (String coachName : names.getCoachNames()) {
            result.add(new CoachData(coachName, nonPreferredFoodReader.read(coachName)));
        }
        return result;
    }
}
