package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputNumberValidatorTest {
    InputNumberValidator validator = new InputNumberValidator();

    @Test
    @DisplayName("주어진 범위에 맞는 정상적인 숫자 검증")
    void enterNumberInRange() {
        //given
        String generatedNumber = "10";

        //when and then
        assertThatCode(() -> validator.isValidBonusNumber(generatedNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("주어진 범위에 벗어난 숫자 검증")
    void enterNumberNotInRange() {
        //given
        String lessThanRangeNumber = "-1";
        String greaterThanRangeNumber = "50";

        // when and then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.isValidBonusNumber(lessThanRangeNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.isValidBonusNumber(greaterThanRangeNumber));
    }

    @Test
    @DisplayName("콤마로 잘 구분된 경우")
    void isDividedWithComma() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        String properInput = validator.isDividedWithComma(input);

        // then
        assertThat(properInput).isEqualTo(input);
    }

    @Test
    @DisplayName("콤마외의 문자로 나뉜 경우")
    void notIsDividedWithComma() {
        // given
        String input = "1,2.3,4/5,6";

        // when and then
        assertThrows(IllegalArgumentException.class, () ->
                validator.isDividedWithComma(input)
        );
    }

    @Test
    @DisplayName("구매 금액이 숫자로만 이루어져 있는지 확인")
    void checkValidInput() {
        String inputDigit = "4000";
        String inputDigitWithComma = "4,000";
        String inputChar = "4e3";

        assertThat(validator.isValidBuyAmount(inputDigit)).isEqualTo(4000);
        assertThat(validator.isValidBuyAmount(inputDigitWithComma)).isEqualTo(4000);
        assertThatIllegalArgumentException().isThrownBy(() ->
                validator.isValidBuyAmount(inputChar)
        );
    }
}