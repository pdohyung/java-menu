package menu.view;

import static java.text.MessageFormat.*;

public class OutputView {
    private static final String PRINT_MENU_RECOMMEND_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String PRINT_MENU_RECOMMEND_END_MESSAGE = "\n추천을 완료했습니다.";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] {0}";

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printMenuRecommendStart() {
        System.out.println(PRINT_MENU_RECOMMEND_START_MESSAGE);
    }

    public void printMenuRecommendEnd() {
        System.out.println(PRINT_MENU_RECOMMEND_END_MESSAGE);
    }
}
