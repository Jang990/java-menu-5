package menu;

import menu.category.DayOfWeek;
import menu.category.WeekCategory;
import menu.coach.CoachMenu;
import menu.io.coach.CoachData;
import menu.menu.ResultFormatter;
import menu.menu.MenuRecommender;

import java.util.List;

public class MyMenuApp {
    private final WeekCategory weekCategory;
    private final MenuRecommender menuRecommender;
    private final ResultFormatter formatter;

    public MyMenuApp(
            WeekCategory weekCategory,
            MenuRecommender menuRecommender,
            ResultFormatter formatter) {
        this.weekCategory = weekCategory;
        this.menuRecommender = menuRecommender;
        this.formatter = formatter;
    }

    public void run(List<CoachData> coachDataList) {
        List<CoachMenu> coachMenus = coachDataList.stream().map(CoachMenu::new).toList();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            coachMenus.forEach(
                    coachMenu -> coachMenu.add(menuRecommender.recommend(
                            weekCategory.get(dayOfWeek), coachMenu)));
        }
        System.out.println(formatter.formatted(weekCategory, coachMenus));
    }
}
