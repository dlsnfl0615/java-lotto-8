package lotto.domain;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final WinningStatistics statistics;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber, int buyAmount) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        statistics = new WinningStatistics(buyAmount);
    }

    public List<String> repeat(int buyAmount) {
        for (int i = 0; i < buyAmount / 1000; i++) {
            Rank rank = buyLotto();
            statistics.addRank(rank);
        }

        return statistics.getStatistics();
    }

    public Rank buyLotto() {
        List<Integer> generatedNumbers = LottoGenerator.generateNumbers();

        LottoSheet lottoSheet = new LottoSheet(generatedNumbers);

        int regularMatchCount = lottoSheet.countRegularMatch(winningNumbers, bonusNumber);
        int bonusMatchCount = lottoSheet.countBonusMatch(bonusNumber);

        return RankCalculator.calculateRank(regularMatchCount, bonusMatchCount);
    }
}
