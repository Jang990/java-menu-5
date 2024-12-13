package menu.category;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekCategoryTest {

    @Test
    void 주간_카테고리의_크기가_5가_아니라면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new WeekCategory(List.of(
                        Category.CHN, Category.KOR,
                        Category.ASIAN, Category.KOR)));

        assertThrows(IllegalArgumentException.class,
                () -> new WeekCategory(List.of(
                        Category.CHN, Category.KOR,
                        Category.ASIAN, Category.KOR,
                        Category.ASIAN, Category.WESTERN)));
    }

    @Test
    void 등장_빈도가_주에_2번을_초과하는_카테고리가_있다면_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> new WeekCategory(List.of(
                        Category.CHN, Category.KOR,
                        Category.KOR, Category.KOR)));
    }

    @Test
    void 각_요일별_카테고리_확인가능() {
        WeekCategory weekCategory = new WeekCategory(List.of(
                Category.CHN,
                Category.KOR,
                Category.ASIAN,
                Category.JPN,
                Category.WESTERN));

        assertEquals(Category.CHN, weekCategory.get(DayOfWeek.Monday));
        assertEquals(Category.KOR, weekCategory.get(DayOfWeek.Tuesday));
        assertEquals(Category.ASIAN, weekCategory.get(DayOfWeek.Wednesday));
        assertEquals(Category.JPN, weekCategory.get(DayOfWeek.Thursday));
        assertEquals(Category.WESTERN, weekCategory.get(DayOfWeek.Friday));
    }

    @Test
    void 주간_카테고리_정보_출력() {
        assertEquals("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]",
                new WeekCategory(List.of(
                        Category.KOR,
                        Category.KOR,
                        Category.JPN,
                        Category.CHN,
                        Category.ASIAN)).toString());
    }
}