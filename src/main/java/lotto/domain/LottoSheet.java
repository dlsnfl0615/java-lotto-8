package lotto.domain;

import java.util.List;

public class LottoSheet {
    private final List<Integer> numbers;

    public LottoSheet(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countRegularMatch(List<Integer> winningNumbers, int bonusNumber) {
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int countBonusMatch(int bonusNumber) {
        return (int)numbers.stream()
                .filter(n -> n == bonusNumber)
                .count();
    }
}
