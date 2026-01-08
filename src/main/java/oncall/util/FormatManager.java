package oncall.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatManager {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E", Locale.KOREAN);
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String DELIMITER = ",";
    public static final int MAX_LENGTH = 5;
    public static final int MIN_SIZE = 5;
    public static final int MAX_SIZE = 35;
    public static final int JANUARY = 1;
    public static final int DECEMBER = 12;
}
