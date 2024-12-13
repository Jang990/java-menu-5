package menu.menu;

import menu.RandomUtils;
import menu.category.Category;
import menu.coach.CoachMenu;

public class MenuRecommender {
    private final RandomUtils randomUtils;

    public MenuRecommender(RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
    }

    public String recommend(Category category, CoachMenu coachMenu) {
        String result = null;
        while (coachMenu.isInedible(result)) {
            result = randomUtils.pickRandom(MenuBoard.get(category));
        }
        return result;
    }
}
