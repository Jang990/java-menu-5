package menu.io.coach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachNamesTest {

    @Test
    void 코치_이름_길이가_범위밖이면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new CoachNames(List.of("1")));
        assertThrows(IllegalArgumentException.class, () -> new CoachNames(List.of("12345")));
    }

    @Test
    void 코치의_수가_범위밖이면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new CoachNames(List.of("1")));
        assertThrows(IllegalArgumentException.class, () -> new CoachNames(List.of("1", "2", "3", "4", "5", "6")));
    }

    @Test
    void 코치의_이름을_받을_수_있다() {
        assertEquals(List.of("11", "22", "33"),
                new CoachNames(List.of("11", "22", "33")).getCoachNames());
    }

}