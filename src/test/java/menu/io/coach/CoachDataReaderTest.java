package menu.io.coach;

import menu.io.InputReaderStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachDataReaderTest {

    @Test
    void 코치_데이터를_가져옴() {
        InputReaderStub inputReaderStub = new InputReaderStub("11,22");
        CoachDataReader coachNameReader =
                new CoachDataReader(
                        new CoachNameReader(inputReaderStub),
                        new NonPreferredFoodReader(inputReaderStub));

        List<CoachData> result = coachNameReader.read();
        assertEquals("11", result.get(0).getName());
        assertEquals(List.of("11", "22"), result.get(0).getNonPreferredFoods());

        assertEquals("22", result.get(1).getName());
        assertEquals(List.of("11", "22"), result.get(1).getNonPreferredFoods());
    }

}