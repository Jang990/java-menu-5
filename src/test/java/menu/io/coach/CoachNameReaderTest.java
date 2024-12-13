package menu.io.coach;

import menu.io.InputReaderStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachNameReaderTest {
    @Test
    void 코치_이름을_콤마로_구분해서_읽음() {
        CoachNameReader coachNameReader =
                new CoachNameReader(new InputReaderStub("11,22,33"));

        CoachNames result = coachNameReader.read();

        assertEquals(List.of("11", "22", "33"), result.getCoachNames());
    }

}