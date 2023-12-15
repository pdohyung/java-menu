package menu.view;

import menu.util.validator.CanNotEatValidator;
import menu.util.validator.CoachNamesValidator;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);
    private static final String INPUT_COACH_NAMES_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_CAN_NOT_EAT_MESSAGE_FORMAT = "\n{0}(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> inputCoachNames() {
        System.out.println(INPUT_COACH_NAMES_MESSAGE);
        return CoachNamesValidator.validateInputCoachNames(sc.nextLine());
    }

    public List<String> inputCanNotEat(String coachName) {
        System.out.println(MessageFormat.format(INPUT_CAN_NOT_EAT_MESSAGE_FORMAT, coachName));
        return CanNotEatValidator.validateInputCanNotEat(sc.nextLine());
    }
}
