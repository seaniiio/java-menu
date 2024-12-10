package menu.constant;

public enum ErrorMessage {
    INPUT_FORMAT_ERROR("입력 형식이 올바르지 않습니다."),
    COACH_NAME_LENGTH_ERROR("코치의 이름은 2자 이상 4자 이하여야 합니다."),
    COACH_NUMBER_ERROR("코치는 2명 이상 5명 이하여야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return PREFIX + errorMessage;
    }
}
