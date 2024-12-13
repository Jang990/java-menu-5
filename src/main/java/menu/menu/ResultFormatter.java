package menu.menu;

import menu.category.WeekCategory;
import menu.coach.CoachMenu;

import java.util.List;

public class ResultFormatter {

    public String formatted(WeekCategory weekCategory, List<CoachMenu> coachMenus) {
        StringBuilder builder = new StringBuilder();
        builder.append("메뉴 추천 결과입니다.").append(System.lineSeparator());
        builder.append("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]").append(System.lineSeparator());
        builder.append(weekCategory.toString()).append(System.lineSeparator());
        builder.append(createCoachMenusString(coachMenus)).append(System.lineSeparator());
        builder.append("추천을 완료했습니다.");
        return builder.toString();
    }

    private String createCoachMenusString(List<CoachMenu> coachMenus) {
        StringBuilder builder = new StringBuilder();
        coachMenus.forEach(
                coachMenu -> builder.append(coachMenu.toString()).append(System.lineSeparator()));
        return builder.toString();
    }
}
