package menu.util.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.Constants.*;
import static menu.util.ErrorMessage.*;

public class CoachNamesValidator {
    public static List<String> validateInputCoachNames(String input) {
        List<String> coachNames = splitInputCoachNamesByComma(input);
        validateCoachesNumber(coachNames);
        validateNamesLength(coachNames);
        return coachNames;
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

    private static void validateCoachesNumber(List<String> coachNames) {
        int coachesNumber = coachNames.size();
        if (coachesNumber < COACHES_MIN_NUMBER || coachesNumber > COACHES_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_MESSAGE.getErrorMessage());
        }
    }

    private static void validateNamesLength(List<String> coachNames) {
        boolean hasInvalidNameLength = coachNames.stream()
                .anyMatch(name -> name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH);
        if (hasInvalidNameLength) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_MESSAGE.getErrorMessage());
        }
    }
}
