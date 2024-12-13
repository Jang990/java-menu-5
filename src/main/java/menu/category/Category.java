package menu.category;

public enum Category {
    JPN(1, "일식"),
    KOR(2, "한식"),
    CHN(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    public static Category get(int categoryId) {
        for (Category category : Category.values()) {
            if(category.id == categoryId)
                return category;
        }
        throw new IllegalArgumentException();
    }

    private final int id;
    private final String name;

    Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
