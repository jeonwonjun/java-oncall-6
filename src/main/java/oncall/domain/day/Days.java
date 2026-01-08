package oncall.domain.day;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Days {
    private List<Day> days = new ArrayList<>();

    public void changeWork() {
        for (int i = 1; i < days.size(); i++) {
            if (checkName(i)) {
                int nextPerson = checkNextPerson(i);
                String tempName = days.get(i).getName();
                days.get(i).setName(days.get(nextPerson).getName());
                days.get(nextPerson).setName(tempName);

            }
        }
    }

    private int checkNextPerson(int startIndex) {
        for (int i = startIndex + 1; i < days.size(); i++) {
            if (checkDescriptionType(startIndex) == checkDescriptionType(i)) {
                return i;
            }
        }
        return startIndex;
    }

    private boolean checkName(int index) {
        return days.get(index).getName().equals(days.get(index-1).getName());
    }

    private boolean checkDescriptionType(int index) {
        return (days.get(index).getDescription().matches("[월화수목금]$")) && !days.get(index).isHoliday();
    }

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
