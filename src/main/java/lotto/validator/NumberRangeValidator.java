package lotto.validator;

public class NumberRangeValidator {
    private static final int minimumNumber = 1;
    private static final int maximumNumber = 45;
    private static final String errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void isInRange(int generatedNumber) {
        if (generatedNumber < minimumNumber || generatedNumber > maximumNumber) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
