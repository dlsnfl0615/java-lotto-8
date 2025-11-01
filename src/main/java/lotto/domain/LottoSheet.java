package lotto.domain;

import java.util.List;

public class LottoSheet {
    private final List<Integer> numbers;

    public LottoSheet(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchedCount(List<Integer> winningNumbers, int bonusNumber) {
        int matchedNumbers = (int)numbers.stream()
                                .filter(winningNumbers::contains)
                                .count();
        return matchedNumbers + getMatchedBonusCount(bonusNumber);
    }

    public int getMatchedBonusCount(int bonusNumber) {
        return (int)numbers.stream()
                .filter(n -> n == bonusNumber)
                .count();
    }
}
