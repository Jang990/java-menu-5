package menu.io.coach;

import java.util.List;

public class CoachData {
    private final String name;
    private final List<String> nonPreferredFoods;

    public CoachData(String name, NonPreferredFoods nonPreferredFoods) {
        this.name = name;
        this.nonPreferredFoods = nonPreferredFoods.getFoods();
    }

    public String getName() {
        return name;
    }

    public List<String> getNonPreferredFoods() {
        return nonPreferredFoods;
    }
}
