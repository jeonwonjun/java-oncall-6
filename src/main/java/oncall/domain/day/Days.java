package oncall.domain.day;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Days {
    private List<Day> days = new ArrayList<>();

    public void addCalendar(int month, String startDescription) {
        int dayNumber = DayDescription.geStartIndex(startDescription);

        int year = 2026;
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        for (int day=1; day<=daysInMonth; day++) {
            String description = DayDescription.getCurrentDescription(day-1 + dayNumber);
            days.add(new Day(month, day, description));
        }
    }

    public void addEmployee(List<String> weekdayList, List<String> weekendList) {
        int weekdayIndex=0;
        int weekendIndex=0;
        for (Day day : days) {
            if (Holidays.isHoliday(day.getMonth(), day.getDay()) || day.getDescription().matches("[토일]")) {
                day.setName(addWeekend(weekendList, weekendIndex));
                weekendIndex++;
            }
            if (!Holidays.isHoliday(day.getMonth(), day.getDay()) && day.getDescription().matches("[월화수목금]")) {
                day.setName(addWeekday(weekdayList, weekdayIndex));
                weekdayIndex++;
            }
            if (weekdayIndex >= weekdayList.size()) {
                weekdayIndex = 0;
            }
            if (weekendIndex >= weekendList.size()) {
                weekendIndex = 0;
            }
        }
    }

    private String addWeekday(List<String> weekdayList, int index) {
        return weekdayList.get(index);
    }

    private String addWeekend(List<String> weekendList, int index) {
        return weekendList.get(index);
    }

    public List<Day> getDays() {
        return days;
    }
}
