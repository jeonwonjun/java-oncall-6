package oncall.util;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INVALID_EMPLOYEE_COUNT("적정 인원수가 아닙니다."),
    INVALID_EMPLOYEE_NAME_LENGTH("적정 이름 길이가 아닙니다."),
    INVALID_DIFFERENT_LIST("평일과 휴일 근무자 인원이 다릅니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return FormatManager.ERROR_PREFIX + message;
    }
}
