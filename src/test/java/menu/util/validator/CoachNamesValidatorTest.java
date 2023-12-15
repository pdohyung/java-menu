package menu.util.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CoachNamesValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"포,포비", "포포비비,포포포비비"})
    void 최소_2글자_최대_4글자가_아닌_경우_예외_발생(String input) {
        assertThatThrownBy(() -> CoachNamesValidator.validateInputCoachNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비,토미,제임스,코코,앤디,도형", "도형"})
    void 최소_2명_최대_5명이_아닌_경우_예외_발생(String input) {
        assertThatThrownBy(() -> CoachNamesValidator.validateInputCoachNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}