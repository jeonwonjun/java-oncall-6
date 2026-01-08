package oncall.controller;

import java.nio.file.NoSuchFileException;
import java.util.List;
import oncall.domain.day.Day;
import oncall.domain.day.Days;
import oncall.domain.day.StartDay;
import oncall.domain.employee.WeekdayEmployee;
import oncall.domain.employee.WeekendEmployee;
import oncall.util.ErrorMessage;
import oncall.util.FormatManager;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    public void run() {
        StartDay monthAndDescription = readMonth();
        List<Day> resultSchedule = OrganizeWorkSchedule(monthAndDescription);

        OutputView.printResult(resultSchedule);
    }

    private StartDay readMonth() {
        while (true) {
            try {
                String monthAndDay = InputView.readMonthAndDay();
                return new StartDay(monthAndDay);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    private List<Day> OrganizeWorkSchedule(StartDay startDay) {
        while (true) {
            try {
                WeekdayEmployee weekdayEmployee = new WeekdayEmployee(InputView.readWeekdayWorkList());
                WeekendEmployee weekendEmployee = new WeekendEmployee(InputView.readWeekendWorkList());
                Days days = new Days();
                days.addCalendar(startDay.getStartMonth(), startDay.getStartDescription());
                days.addEmployee(weekdayEmployee.getWeekDayList(), weekendEmployee.getWeekendList());
                days.changeWork();
                return days.getDays();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }
}
