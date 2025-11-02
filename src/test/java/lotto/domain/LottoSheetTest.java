package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSheetTest {
    @Test
    @DisplayName("몇 개가 당첨됐는지 확인")
    void countWinningNumbers() {
        List<Integer> winningNumbers = List.of(4, 5, 6, 8, 9, 10);
        List<Integer> generatedNumbers = List.of(1, 2, 7, 4, 5, 6);
        int bonusNumber = 7;
        LottoSheet lottoSheet = new LottoSheet(generatedNumbers);
        int matchedCount = lottoSheet.countRegularMatch(winningNumbers, bonusNumber);
        assertThat(matchedCount).isEqualTo(4);
    }
}