package menu.menu;

import menu.RandomUtils;
import menu.category.Category;
import menu.coach.CoachMenu;
import menu.io.coach.CoachData;
import menu.io.coach.NonPreferredFoods;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuRecommenderTest {

    // TODO: 테스트 개선 필요. 랜덤이라 결과가 달라질 수 있음
    @Test
    void 현재_코치가_먹을_수_있는_랜덤_메뉴를_추천함() {
        NonPreferredFoods nonPreferredFoods = new NonPreferredFoods(List.of("팟타이", "카오 팟"));
        CoachMenu coachMenu = new CoachMenu(new CoachData("ABC", nonPreferredFoods));
        MenuRecommender recommender = new MenuRecommender(new RandomUtils());

        String result = recommender.recommend(Category.ASIAN, coachMenu);

        assertNotEquals("팟타이", result);
        assertNotEquals("카오 팟", result);
        assertFalse(coachMenu.isInedible(result));
    }

    @Test
    void 추천된_메뉴는_카테고리에_해당함() {
        NonPreferredFoods nonPreferredFoods = new NonPreferredFoods(List.of());
        CoachMenu coachMenu = new CoachMenu(new CoachData("ABC", nonPreferredFoods));
        MenuRecommender recommender = new MenuRecommender(new RandomUtils());

        String result = recommender.recommend(Category.ASIAN, coachMenu);

        assertTrue(MenuBoard.get(Category.ASIAN).contains(result));
    }

}