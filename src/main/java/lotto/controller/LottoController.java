package lotto.controller;

import lotto.service.LottoMachine;
import lotto.validator.InputNumberValidator;
import lotto.view.InputNumbers;
import lotto.view.OutputStatistics;

import java.util.List;

public class LottoController {
    private final InputNumbers input;
    private final OutputStatistics output;
    private final InputNumberValidator validator;
    private final LottoMachine lottoMachine;

    public LottoController(InputNumbers input, OutputStatistics output, InputNumberValidator validator, LottoMachine lottoMachine) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        // 구매 금액 입력
        int buyAmount = readBuyAmount();

        // 로또 발매
        List<List<Integer>> lottoTickets = lottoMachine.buyLotto(buyAmount);
        output.printLottoTickets(lottoTickets, buyAmount);

        // 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = readNumbers();
        int bonusNumber = readBonusNumber();

        // 당첨 확인
        List<String> statistics = lottoMachine.calculateRanks(lottoTickets, winningNumbers, bonusNumber, buyAmount);

        // 출력
        output.printResult(statistics);
    }

    public int readBuyAmount() {
        while (true) {
            String buyAmount = input.inputBuyAmount();

            try {
                return validator.isValidBuyAmount(buyAmount);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public List<Integer> readNumbers() {
        while (true) {
            String winningNumbers = input.inputWinningNumbers();

            try {
                return validator.separateInput(winningNumbers);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            String bonusNumber = input.inputBonusNumber();

            try {
                return validator.isValidBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
