package menu.controller;

import menu.domain.Coach;
import menu.domain.enums.Days;
import menu.domain.MenuRecommendResult;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendResult menuRecommendResult;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuRecommendResult = new MenuRecommendResult();
    }

    public void run() {
        outputView.printMenuRecommendStart();
        List<String> coachNames = retryInputCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> canNotEatMenus = retryInputCanNotEat(coachName);
            coaches.add(new Coach(coachName, canNotEatMenus));
        }
        recommend(coaches);
        outputView.printMenuRecommendResult(menuRecommendResult.getMenuRecommendResult());
        outputView.printMenuRecommendEnd();
    }

    public void recommend(List<Coach> coaches) {
        for (Days day : Days.values()) {
            for (Coach coach : coaches) {
                menuRecommendResult.createRecommend(day, coach);
            }
        }
    }

    private List<String> retryInputCoachNames() {
        while (true) {
            try {
                return inputView.inputCoachNames();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> retryInputCanNotEat(String coachName) {
        while (true) {
            try {
                return inputView.inputCanNotEat(coachName);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
