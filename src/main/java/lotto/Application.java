package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoMachine;
import lotto.domain.WinningStatistics;
import lotto.validator.InputNumberValidator;
import lotto.view.InputNumbers;
import lotto.view.OutputStatistics;

public class Application {
    public static void main(String[] args) {
        InputNumbers input = new InputNumbers();
        OutputStatistics output = new OutputStatistics();
        InputNumberValidator validator = new InputNumberValidator();
        LottoMachine machine = new LottoMachine(new WinningStatistics());

        LottoController controller = new LottoController(input, output, validator, machine);

        controller.run();
    }
}
