package menu.category;

import java.util.Arrays;
import java.util.List;

public class CategoryFrequencyFinder {
    public static List<Integer> find(List<Category> categories) {
        int[] frequency = new int[DayOfWeek.WORK_DAYS_SIZE + 1];
        categories.stream().mapToInt(Category::getId).forEach(id -> frequency[id]++);

        return Arrays.stream(frequency)
                .boxed()
                .toList();
    }
}
