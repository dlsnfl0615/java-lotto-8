package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("몇 개가 당첨됐는지 확인")
    void countWinningNumbers() {
        List<Integer> winningNumbers = List.of(4, 5, 6, 8, 9, 10);
        List<Integer> generatedNumbers = List.of(1, 2, 7, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(generatedNumbers);

        int regularNumbersMatched = lotto.countRegularNumbers(winningNumbers);
        int bonusNumberMatched = lotto.countBonusNumber(bonusNumber);

        assertThat(regularNumbersMatched).isEqualTo(3);
        assertThat(bonusNumberMatched).isEqualTo(1);
    }
}
