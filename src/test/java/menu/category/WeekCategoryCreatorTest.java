package menu.category;

import menu.RandomUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekCategoryCreatorTest {

    @Test
    void 주간_카테고리의_사이즈는_5로_고정() {
        WeekCategoryCreator creator = new WeekCategoryCreator(new RandomUtils());
        assertEquals(5, creator.create().size());
    }

    @Test
    void 모든_카테고리_최고_등장_빈도는_2이하() {
        WeekCategoryCreator creator = new WeekCategoryCreator(new RandomUtils());
        assertTrue(CategoryFrequencyFinder.find(creator.create())
                .stream().mapToInt(Integer::valueOf)
                .max()
                .getAsInt() <= 2);
    }

}