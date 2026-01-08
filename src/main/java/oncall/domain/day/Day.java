package oncall.domain.day;

public class Day {
    private final int month;
    private final int day;
    private final String description;
    private boolean holiday;
    private String name;

    public Day(int month, int day, String description) {
        this.month = month;
        this.day = day;
        this.description = description;
        this.holiday = isWeekdayHoliday(month, day);
    }

    private boolean isWeekdayHoliday(int month, int day) {
        if (this.description.matches("[월화수목금]$") && Holidays.isHoliday(month, day)) {
            return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public String getName() {
        return name;
    }
}
