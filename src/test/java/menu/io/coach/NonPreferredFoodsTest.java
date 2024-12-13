package menu.io.coach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NonPreferredFoodsTest {

    @Test
    void 비선호_음식의_수가_범위밖이면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new NonPreferredFoods(List.of("1", "2", "3")));
    }

    @Test
    void 비선호_음식의_이름을_받을_수_있다() {
        assertEquals(List.of("11", "22"),
                new NonPreferredFoods(List.of("11", "22")).getFoods());
    }

}