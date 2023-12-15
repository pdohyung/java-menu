package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidator;

import java.util.List;

public class InputView {
    private static final String INPUT_COACH_NAMES_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> inputCoachNames() {
        System.out.println(INPUT_COACH_NAMES_MESSAGE);
        return InputValidator.validateInputCoachNames(Console.readLine());
    }
}
