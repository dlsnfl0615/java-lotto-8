package lotto.error;

public enum ErrorMessages {
    OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_COMMA("[ERROR] 각 숫자는 쉼표로만 구분되어야 합니다: "),
    NOT_MULTIPLE_THOUSAND("[ERROR] 구매 금액은 1000의 배수이어야 합니다."),
    NOT_DIGIT("[ERROR] 구매 금액은 숫자만 가능합니다."),
    DUPLICATION("[ERROR] 로또 번호는 중복될 수 없습니다."),
    NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    ZERO("[ERROR] 최소 한 개 이상의 로또를 구매해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
