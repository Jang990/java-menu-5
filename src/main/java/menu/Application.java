package menu;

import menu.category.WeekCategory;
import menu.category.WeekCategoryCreator;
import menu.io.InputReader;
import menu.io.coach.CoachDataReader;
import menu.io.coach.CoachNameReader;
import menu.io.coach.NonPreferredFoodReader;
import menu.io.retry.CoachDataReaderErrorLoggingAspect;

public class Application {
    public static void main(String[] args) {
        CoachDataReader coachDataReader = coachDataReader();
        WeekCategory weekCategory = weekCategory(weekCategoryCreator());
    }

    private static WeekCategory weekCategory(WeekCategoryCreator creator) {
        return new WeekCategory(creator.create());
    }

    private static WeekCategoryCreator weekCategoryCreator() {
        return new WeekCategoryCreator(randomUtils());
    }

    private static RandomUtils randomUtils() {
        return new RandomUtils();
    }

    private static CoachDataReader coachDataReader() {
        return new CoachDataReaderErrorLoggingAspect(
                new CoachDataReader(
                        coachNameReader(inputReader()),
                        nonPreferredFoodReader(inputReader())));
    }

    private static InputReader inputReader() {
        return new InputReader();
    }

    private static CoachNameReader coachNameReader(InputReader inputReader) {
        return new CoachNameReader(inputReader);
    }

    private static NonPreferredFoodReader nonPreferredFoodReader(InputReader inputReader) {
        return new NonPreferredFoodReader(inputReader);
    }
}
