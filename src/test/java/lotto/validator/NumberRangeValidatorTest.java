package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberRangeValidatorTest {
    @Test
    @DisplayName("주어진 범위에 맞는 정상적인 숫자 검증")
    void enterNumberInRange() {
        //given
        int generatedNumber = 10;

        //when and then
        assertThatCode(() -> NumberRangeValidator.isInRange(generatedNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("주어진 범위에 벗어난 숫자 검증")
    void enterNumberNotInRange() {
        //given
        int lessThanRangeNumber = -1;
        int greaterThanRangeNumber = 50;

        // when and then
        assertThatIllegalArgumentException().isThrownBy(() -> NumberRangeValidator.isInRange(lessThanRangeNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> NumberRangeValidator.isInRange(greaterThanRangeNumber));
    }
}