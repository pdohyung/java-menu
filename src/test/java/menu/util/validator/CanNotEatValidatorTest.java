package menu.util.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CanNotEatValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"깐풍기,뇨끼,바게트"})
    void 최소_0개_최대_2개가_아닌_경우_예외_발생(String input) {
        assertThatThrownBy(() -> CanNotEatValidator.validateInputCanNotEat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 먹지_못하는_메뉴가_없으면_빈_값을_입력한다(String input) {
        assertThat(CanNotEatValidator.validateInputCanNotEat(input)).isEqualTo(List.of(""));
    }
}