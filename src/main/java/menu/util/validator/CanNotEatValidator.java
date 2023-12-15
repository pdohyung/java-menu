package menu.util.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.Constants.*;
import static menu.util.ErrorMessage.*;

public class CanNotEatValidator {
    public static List<String> validateInputCanNotEat(String input) {
        List<String> canNotEatMenus = splitInputCanNotEatByComma(input);
        return canNotEatMenus;
    }

    private static List<String> splitInputCanNotEatByComma(String input) {
        if (input.startsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_CAN_NOT_EAT_MESSAGE.getErrorMessage());
        }
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_CAN_NOT_EAT_MESSAGE.getErrorMessage());
        }
        return Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());
    }
}
