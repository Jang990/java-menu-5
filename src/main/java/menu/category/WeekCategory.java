package menu.category;

import java.util.List;

public class WeekCategory {
    private static final String TO_STRING_FORMAT = "[ 카테고리 | %s ]";
    private static final String DELIMITER = " | ";

    private List<Category> category;

    public WeekCategory(List<Category> category) {
        this.category = category;
    }

    public Category get(DayOfWeek dayOfWeek) {
        return category.get(dayOfWeek.getIdx());
    }

    public int size() {
        return category.size();
    }

    @Override
    public String toString() {
        return TO_STRING_FORMAT
                .formatted(String.join(DELIMITER, category.stream()
                        .map(Category::getName)
                        .toList()));
    }
}
