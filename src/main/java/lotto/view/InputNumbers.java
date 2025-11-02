package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputNumbers {
    private final String BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputBuyAmount() {
        System.out.println(BUY_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }
}
