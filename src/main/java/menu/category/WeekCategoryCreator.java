package menu.category;

import menu.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class WeekCategoryCreator {
    private final RandomUtils randomUtils;
    private static final int MAX_FREQUENCY = 2;


    public WeekCategoryCreator(RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
    }

    public List<Category> create() {
        List<Category> result = new LinkedList<>();
        while (result.size() < DayOfWeek.WORK_DAYS_SIZE) {
            Category current = Category.get(getRandomCategoryId());
            if(isValid(CategoryFrequencyFinder.find(result), current))
                result.add(current);
        }
        return result;
    }

    private boolean isValid(List<Integer> categoryFrequency, Category current) {
        return categoryFrequency.get(current.getId()) < MAX_FREQUENCY;
    }

    private int getRandomCategoryId() {
        return randomUtils
                .pickNumberInRange(
                        Category.JPN.getId(),
                        Category.WESTERN.getId());
    }
}
