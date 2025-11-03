package lotto.domain;

import lotto.error.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_COUNT.getMessage());
        }

        hasDuplication(numbers);
    }

    public void hasDuplication(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>(numbers);

        if (numbers.size() != unique.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATION.getMessage());
        }
    }

    // 보너스 번호가 아닌 일반 번호 대조
    public int countRegularNumbers(List<Integer> winningNumbers) {
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int countBonusNumber(int bonusNumber) {
        return (int)numbers.stream()
                .filter(n -> n == bonusNumber)
                .count();
    }
}
