package menu.constant;

public enum Weekdays {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    ;

    private final String name;

    Weekdays(String name) {
        this.name = name;
    }

    public static String getMessage() {
        String message = "[ 구분";

        for (Weekdays day : Weekdays.values()) {
            message += (" | " + day.name);
        }
        message += " ]";

        return message;
    }
}
