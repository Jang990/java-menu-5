package menu.io.coach;

public class CoachData {
    private final String name;
    private final NonPreferredFoods nonPreferredFoods;

    public CoachData(String name, NonPreferredFoods nonPreferredFoods) {
        this.name = name;
        this.nonPreferredFoods = nonPreferredFoods;
    }

    public String getName() {
        return name;
    }

    public NonPreferredFoods getNonPreferredFoods() {
        return nonPreferredFoods;
    }
}
