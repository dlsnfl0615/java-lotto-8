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
        int buyAmount = readBuyAmount();

        List<List<Integer>> lottoTickets = lottoMachine.buyLotto(buyAmount);
        output.printLottoTickets(lottoTickets, buyAmount);

        List<Integer> winningNumbers = readNumbers();

        int bonusNumber = readBonusNumber();

        List<String> statistics = lottoMachine.calculateRanks(lottoTickets, winningNumbers, bonusNumber, buyAmount);

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
