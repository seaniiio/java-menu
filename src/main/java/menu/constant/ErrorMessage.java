package menu.constant;

public enum ErrorMessage {
    INPUT_FORMAT_ERROR("입력 형식이 올바르지 않습니다."),
    COACH_NAME_LENGTH_ERROR("코치의 이름은 2자 이상 4자 이하여야 합니다."),
    COACH_NUMBER_ERROR("코치는 2명 이상 5명 이하여야 합니다."),
    MENU_NOT_EXIST_ERROR("입력하신 메뉴는 존재하지 않습니다."),
    PROHIBITED_MENUS_NUMBER_ERROR("먹지 못하는 음식은 0개 이상 2개 이하여야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return PREFIX + errorMessage;
    }
}
