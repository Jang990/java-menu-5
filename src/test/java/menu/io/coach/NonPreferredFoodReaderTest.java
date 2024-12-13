package menu.io.coach;

import menu.io.InputReaderStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NonPreferredFoodReaderTest {

    @Test
    void 비선호_음식의_이름을_콤마로_구분해서_읽음() {
        NonPreferredFoodReader coachNameReader =
                new NonPreferredFoodReader(new InputReaderStub("11,22"));
        NonPreferredFoods result = coachNameReader.read("ABC");
        assertEquals(List.of("11", "22"), result.getFoods());
    }
}