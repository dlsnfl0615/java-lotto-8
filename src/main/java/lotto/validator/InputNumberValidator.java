package lotto.validator;

import lotto.error.ErrorMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumberValidator {
    private final int minimumNumber = 1;
    private final int maximumNumber = 45;

    // 구매 금액이 올바른 수인지 검증
    public int isValidBuyAmount(String buyAmount) {
        int inputToInt;

        // 4,000와 같이 쉼표로 자릿수를 구분한 문자열은 입력 허용
        try {
            inputToInt = Integer.parseInt(deleteComma(buyAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIGIT.getMessage());
        }

        if (inputToInt == 0) {
            throw new IllegalArgumentException(ErrorMessages.ZERO.getMessage());
        }

        if (inputToInt % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MULTIPLE_THOUSAND.getMessage());
        }

        return inputToInt;
    }

    public String deleteComma(String buyAmount) {
        if (buyAmount.contains(",")) {
            return buyAmount.replace(",", "");
        }

        return buyAmount;
    }

    // 당첨 번호 분리
    public List<Integer> separateInput(String input) {
        String canDivide = isDividedWithComma(input);

        List<String> separated = Arrays.stream(canDivide.split(",")).toList();

        return isDigit(separated);
    }

    public String isDividedWithComma(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) && ch != ',') {
                throw new IllegalArgumentException(ErrorMessages.NOT_COMMA.getMessage() + ch);
            }
        }

        return input;
    }

    public List<Integer> isDigit(List<String> separated) {
        List<Integer> stringToInteger = new ArrayList<>();
        try {
            for (String number : separated) {
                stringToInteger.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }

        return stringToInteger;
    }

    // 보너스 번호 검증
    public int isValidBonusNumber(String input) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
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
