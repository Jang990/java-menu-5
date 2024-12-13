package menu.io.coach;

import java.util.List;

public class CoachNames {
    private static final int SIZE_MIN = 2;
    private static final int SIZE_MAX = 5;
    private static final String INVALID_SIZE_MESSAGE = "코치는 최소 2명 이상 입력해야 합니다.";
    private static final int NAME_MIN = 2;
    private static final int NAME_MAX = 4;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "코치 이름은 2~4글자여야 합니다.";

    private final List<String> coachNames;

    public CoachNames(List<String> coachNames) {
        if(coachNames == null)
            throw new IllegalArgumentException();
        validateSize(coachNames);
        validateNameLength(coachNames);

        this.coachNames = coachNames;
    }

    private void validateSize(List<String> coachNames) {
        if(coachNames.size() < SIZE_MIN || SIZE_MAX < coachNames.size())
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
    }

    private void validateNameLength(List<String> coachNames) {
        if(isOutOfNameLength(coachNames))
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
    }

    private boolean isOutOfNameLength(List<String> coachNames) {
        return coachNames.stream()
                .mapToInt(String::length)
                .anyMatch(len -> len < NAME_MIN || NAME_MAX < len);
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
