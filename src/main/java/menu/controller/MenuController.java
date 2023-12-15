package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printMenuRecommendStart();
        List<String> coachNames = inputView.inputCoachNames();
    }
}
