package menu.controller;

import menu.domain.Coach;
import menu.domain.enums.Day;
import menu.repository.MenuRecommendRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendRepository menuRecommendRepository;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuRecommendRepository = new MenuRecommendRepository();
    }

    public void run() {
        outputView.printMenuRecommendStart();
        List<String> coachNames = inputView.inputCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> canNotEatMenus = inputView.inputCanNotEat(coachName);
            coaches.add(new Coach(coachName, canNotEatMenus));
        }
        recommend(coaches);
        outputView.printMenuRecommendResult(menuRecommendRepository.getMenuRecommendResult());
        outputView.printMenuRecommendEnd();
    }

    public void recommend(List<Coach> coaches) {
        for (Day day : Day.values()) {
            for (Coach coach : coaches) {
                menuRecommendRepository.createRecommend(day, coach);
            }
        }
    }
}
