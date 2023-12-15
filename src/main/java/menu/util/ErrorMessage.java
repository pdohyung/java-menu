package menu.util;

public enum ErrorMessage {
    INVALID_COACH_NAME_MESSAGE("올바른 코치 이름이 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
