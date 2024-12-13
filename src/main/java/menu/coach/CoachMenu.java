package menu.coach;

import menu.io.coach.CoachData;

import java.util.LinkedList;
import java.util.List;

public class CoachMenu {
    private static final String DELIMITER = " | ";
    private static final String TO_STRING_FORMAT = "[ %s | %s ]";

    private final String coachName;
    private final List<String> nonPreferredFoods;
    private final List<String> menuHistory;

    public CoachMenu(CoachData data) {
        coachName = data.getName();
        nonPreferredFoods = data.getNonPreferredFoods();
        menuHistory = new LinkedList<>();
    }

    public boolean isInedible(String menuName) {
        return menuName == null
                || nonPreferredFoods.contains(menuName)
                || menuHistory.contains(menuName);
    }

    public void add(String menuName) {
        if(isInedible(menuName))
            throw new IllegalArgumentException("먹을 수 없는 음식입니다.");
        menuHistory.add(menuName);
    }

    @Override
    public String toString() {
        return TO_STRING_FORMAT
                .formatted(coachName, String.join(DELIMITER, menuHistory));
    }
}
