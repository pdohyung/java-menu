package menu.util;

public enum ErrorMessage {
    INVALID_COACH_NAME_MESSAGE("올바른 코치 이름이 아닙니다."),
    INVALID_CAN_NOT_EAT_MESSAGE("못 먹는 메뉴 입력이 올바르지 않습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
