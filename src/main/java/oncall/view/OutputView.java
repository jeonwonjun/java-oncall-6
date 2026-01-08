package oncall.view;

import java.util.List;
import oncall.domain.day.Day;
import oncall.domain.day.Days;

public class OutputView {
    public static void printResult(List<Day> daysList) {
        System.out.println();
        for (Day day : daysList) {
            if (day.isHoliday()) {
                printWeekend(day);
            }
            if (!day.isHoliday()) {
                printWeekday(day);
            }
        }
    }

    private static void printWeekday(Day day) {
        System.out.printf("%s월 %s일 %s %s\n", day.getMonth(), day.getDay(), day.getDescription(), day.getName());
    }

    private static void printWeekend(Day day) {
        System.out.printf("%s월 %s일 %s(휴일) %s\n", day.getMonth(), day.getDay(), day.getDescription(), day.getName());
    }
}
