package oncall.domain.day;

import java.util.Arrays;

public enum Holidays {
    ONE_ONE(1, 1),
    THREE_ONE(3, 1),
    FIVE_FIVE(5, 5),
    SIX_SIX(6, 6),
    EIGHT_FIFTEEN(8, 15),
    TEN_THREE(10, 3),
    TEN_NINE(10, 9),
    TWELVE_TWENTY_FIVE(12, 25);

    private final int month;
    private final int day;

    Holidays(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int monthInput, int dayInput) {
        return Arrays.stream(values())
                .anyMatch(holidays -> (holidays.month == monthInput && holidays.day == dayInput));
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
