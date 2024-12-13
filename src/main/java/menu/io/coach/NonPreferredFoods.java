package menu.io.coach;

import java.util.List;

public class NonPreferredFoods {
    private static final int SIZE_MAX = 2;
    private static final String INVALID_SIZE_MESSAGE = "비선호 음식은 2개를 넘을 수 없습니다.";

    private final List<String> foods;

    public NonPreferredFoods(List<String> foods) {
        if(foods == null)
            throw new IllegalArgumentException();
        validateFoodsSize(foods);

        this.foods = foods;
    }

    private void validateFoodsSize(List<String> foods) {
        if(foods.size() > SIZE_MAX)
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
    }

    public List<String> getFoods() {
        return foods;
    }
}
