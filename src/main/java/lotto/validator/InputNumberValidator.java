package lotto.validator;

import lotto.error.ErrorMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumberValidator {
    private final int minimumNumber = 1;
    private final int maximumNumber = 45;

    // 구매 금액이 올바른 수인지 검증
    public int isValidBuyAmount(String userInput) {
        int buyAmount;

        try {
            buyAmount = Integer.parseInt(deleteComma(userInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIGIT.getMessage());
        }

        if (buyAmount == 0) {
            throw new IllegalArgumentException(ErrorMessages.ZERO.getMessage());
        }

        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MULTIPLE_THOUSAND.getMessage());
        }

        return buyAmount;
    }

    public String deleteComma(String buyAmount) {
        if (buyAmount.contains(",")) {
            return buyAmount.replace(",", "");
        }

        return buyAmount;
    }

    // 당첨 번호 분리
    public List<Integer> separateInput(String userInput) {
        String canDivide = isDividedWithComma(userInput);

        List<String> separated = Arrays.stream(canDivide.split(",")).toList();

        return toDigit(separated);
    }

    public String isDividedWithComma(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) && ch != ',') {
                throw new IllegalArgumentException(ErrorMessages.NOT_COMMA.getMessage() + ch);
            }
        }

        return input;
    }

    public List<Integer> toDigit(List<String> separated) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            for (String number : separated) {
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }

        return winningNumbers;
    }

    // 보너스 번호 검증
    public int isValidBonusNumber(String userInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIGIT.getMessage());
        }

        return isInRange(bonusNumber);
    }

    public int isInRange(int bonusNumber) {
        if (bonusNumber < minimumNumber || bonusNumber > maximumNumber) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }

        return bonusNumber;
    }
}
