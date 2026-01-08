package oncall.domain.employee;

import java.util.List;
import oncall.util.ErrorMessage;
import oncall.util.FormatManager;

public class WeekendEmployee {
    private final List<String> weekendList;

    public WeekendEmployee(String weekendEmployees) {
        this.weekendList = parseToWeekendList(weekendEmployees);
    }

    private List<String> parseToWeekendList(String weekendEmployees) {
        List<String> list = List.of(weekendEmployees.split(FormatManager.DELIMITER));
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

    public List<String> getWeekendList() {
        return weekendList;
    }
}
