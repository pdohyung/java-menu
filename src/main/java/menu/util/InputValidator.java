package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.Constants.*;
import static menu.util.ErrorMessage.*;

public class InputValidator {
    public static List<String> validateInputCoachNames(String input) {
        return splitInputCoachNamesByComma(input);
    }

    private static List<String> splitInputCoachNamesByComma(String input) {
        if (input.startsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_MESSAGE.getErrorMessage());
        }
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_MESSAGE.getErrorMessage());
        }
        return Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());
    }
}
