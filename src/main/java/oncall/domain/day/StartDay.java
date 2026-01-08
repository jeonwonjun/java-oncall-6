package oncall.domain.day;

import java.util.List;
import oncall.util.ErrorMessage;
import oncall.util.FormatManager;

public class StartDay {
    private final int startMonth;
    private final String startDescription;

    public StartDay(String dayInput) {
        List<String> start = parseToStartDay(dayInput);
        this.startMonth = parseToMonth(start.get(0));
        this.startDescription = validateStartDescription(start.get(1));
    }

    private List<String> parseToStartDay(String input) {
        return List.of(input.split(FormatManager.DELIMITER));
    }

    public int parseToMonth(String monthInput) {
        int startMonth = Integer.parseInt(monthInput);
        validateStartMonth(startMonth);
        return startMonth;
    }

    private void validateStartMonth(int startMonth) {
        if (startMonth < FormatManager.JANUARY || startMonth > FormatManager.DECEMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private String validateStartDescription(String startDescription) {
        if (!startDescription.matches("^[월화수목금]$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        return startDescription;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public String getStartDescription() {
        return startDescription;
    }
}
