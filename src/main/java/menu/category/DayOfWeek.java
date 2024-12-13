package menu.category;

public enum DayOfWeek {
    Monday(0),
    Tuesday(1),
    Wednesday(2),
    Thursday(3),
    Friday(4);

    public static final int WORK_DAYS_SIZE = 5;

    private final int idx;

    DayOfWeek(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
}
