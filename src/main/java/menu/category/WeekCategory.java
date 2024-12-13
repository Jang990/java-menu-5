package menu.category;

import java.util.Arrays;
import java.util.List;

public class WeekCategory {
    private static final String TO_STRING_FORMAT = "[ 카테고리 | %s ]";
    private static final String DELIMITER = " | ";
    private final int MAX_FREQUENCY = 2;

    private List<Category> category;

    public WeekCategory(List<Category> category) {
        validate(category);
        this.category = category;
    }

    private void validate(List<Category> category) {
        if(category.size() != DayOfWeek.WORK_DAYS_SIZE)
            throw new IllegalArgumentException();
        if(findCategoryFrequency(category).stream()
                .anyMatch(frequency -> frequency > MAX_FREQUENCY))
            throw new IllegalArgumentException();
    }

    private List<Integer> findCategoryFrequency(List<Category> category) {
        int[] frequency = new int[DayOfWeek.WORK_DAYS_SIZE + 1];
        category.stream().mapToInt(Category::getId).forEach(id -> frequency[id]++);

        return Arrays.stream(frequency)
                .boxed()
                .toList();
    }

    public Category get(DayOfWeek dayOfWeek) {
        return category.get(dayOfWeek.getIdx());
    }

    @Override
    public String toString() {
        return TO_STRING_FORMAT
                .formatted(String.join(DELIMITER, category.stream()
                        .map(Category::getName)
                        .toList()));
    }
}
