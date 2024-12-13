package menu.coach;

import menu.io.coach.CoachData;
import menu.io.coach.NonPreferredFoods;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachMenuTest {

    @Test
    void 메뉴추가_시_앞서_먹은_음식이라면_예외발생() {
        CoachMenu coachMenu = new CoachMenu(
                new CoachData("ABC",
                        new NonPreferredFoods(List.of("AA", "BB"))));
        coachMenu.add("CC");

        assertThrows(IllegalArgumentException.class, () -> coachMenu.add("CC"));
    }

    @Test
    void 메뉴추가_시_선호하지_않는_음식이라면_예외발생() {
        CoachMenu coachMenu = new CoachMenu(
                new CoachData("ABC",
                        new NonPreferredFoods(List.of("AA", "BB"))));

        assertThrows(IllegalArgumentException.class, () -> coachMenu.add("AA"));
    }

    @Test
    void 비선호음식_또는_이미_먹은_음식이면_못먹는_음식() {
        CoachMenu coachMenu = new CoachMenu(
                new CoachData("ABC",
                        new NonPreferredFoods(List.of("AA", "BB"))));
        coachMenu.add("CC");

        assertTrue(coachMenu.isInedible("AA"));
        assertTrue(coachMenu.isInedible("CC"));
    }

    @Test
    void 메뉴를_정상적으로_추가했다면_toString에서_정보를_확인할_수_있음() {
        CoachMenu coachMenu = new CoachMenu(
                new CoachData("토미",
                        new NonPreferredFoods(List.of("AA", "BB"))));
        coachMenu.add("쌈밥");
        coachMenu.add("김치찌개");

        assertEquals("[ 토미 | 쌈밥 | 김치찌개 ]", coachMenu.toString());
    }

}