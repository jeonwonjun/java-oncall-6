package oncall.domain.day;

import java.util.Arrays;

public enum DayDescription {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String description;
    private final int index;

    DayDescription(String description, int index) {
        this.description = description;
        this.index = index;
    }

    public static int geStartIndex(String description) {
        return Arrays.stream(values())
                .filter(d -> d.description.equals(description))
                .findFirst()
                .get().index;
    }

    public static String getCurrentDescription(int currentIndex) {
        return Arrays.stream(values())
                .filter(d -> d.index == currentIndex%7)
                .findFirst()
                .get().description;
    }

    public String getDescription() {
        return description;
    }

    public int getIndex() {
        return index;
    }
}
