package menu.view;

import menu.domain.Coach;
import menu.domain.MenuRecommend;
import menu.domain.enums.Day;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.text.MessageFormat.*;

public class OutputView {
    private static final String PRINT_MENU_RECOMMEND_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String PRINT_MENU_RECOMMEND_END_MESSAGE = "\n추천을 완료했습니다.";
    private static final String PRINT_MENU_RECOMMEND_RESULT_START_MESSAGE = "메뉴 추천 결과입니다.";
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

    public void printMenuRecommendResult(Map<Coach, List<MenuRecommend>> menuRecommendResult) {
        Day[] days = Day.values();
        System.out.println(PRINT_MENU_RECOMMEND_RESULT_START_MESSAGE);
        printHeader(days);
        printCategories(menuRecommendResult, days);
        printRecommendations(menuRecommendResult, days);
    }

    private void printHeader(Day[] days) {
        System.out.println("[ 구분 | " + Arrays.stream(days)
                .map(Day::getName)
                .collect(Collectors.joining(" | ")) + " ]");
    }

    private void printCategories(Map<Coach, List<MenuRecommend>> menuRecommendResult, Day[] days) {
        System.out.print("[ 카테고리 | ");
        for (int i = 0; i < days.length; i++) {
            printCategoryForDay(menuRecommendResult, days[i]);
            if (i < days.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    private void printCategoryForDay(Map<Coach, List<MenuRecommend>> menuRecommendResult, Day day) {
        String category = menuRecommendResult.values().stream()
                .flatMap(List::stream)
                .filter(mr -> mr.getDay().equals(day))
                .findFirst()
                .map(mr -> mr.getCategory().getName())
                .orElse("NONE");
        System.out.print(category);
    }

    private void printRecommendations(Map<Coach, List<MenuRecommend>> menuRecommendResult, Day[] days) {
        for (Map.Entry<Coach, List<MenuRecommend>> entry : menuRecommendResult.entrySet()) {
            System.out.print("[ " + entry.getKey().getName() + " | ");
            for (int i = 0; i < days.length; i++) {
                printDishForDay(entry.getValue(), days[i]);
                if (i < days.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" ]");
        }
    }

    private void printDishForDay(List<MenuRecommend> menuRecommends, Day day) {
        String dish = menuRecommends.stream()
                .filter(mr -> mr.getDay().equals(day))
                .findFirst()
                .map(MenuRecommend::getDish)
                .orElse("NONE");
        System.out.print(dish);
    }
}
