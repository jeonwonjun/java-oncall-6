package oncall.domain.employee;

import java.util.List;
import oncall.util.ErrorMessage;
import oncall.util.FormatManager;

public class WeekdayEmployee {

    private final List<String> weekDayList;

    public WeekdayEmployee(String weekDayEmployees) {
        this.weekDayList = parseToWeekDayList(weekDayEmployees);
    }

    private List<String> parseToWeekDayList(String weekDayEmployees) {
        List<String> list = List.of(weekDayEmployees.split(FormatManager.DELIMITER));
        validate(list);
        return list;
    }

    private void validate(List<String> list) {
        validateCount(list);
        validateDistinct(list);
        validateNameLength(list);
    }

    private void validateDistinct(List<String> list) {
        if (list.size() != list.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateNameLength(List<String> list) {
        for (String name : list) {
            if (name.length() > FormatManager.MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_EMPLOYEE_NAME_LENGTH.getMessage());
            }
        }
    }

    private void validateCount(List<String> list) {
        if (list.size() < FormatManager.MIN_SIZE || list.size() > FormatManager.MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EMPLOYEE_COUNT.getMessage());
        }
    }

    public List<String> getWeekDayList() {
        return weekDayList;
    }
}
