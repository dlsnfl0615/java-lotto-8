package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final WinningStatistics statistics;

    public LottoMachine(WinningStatistics statistics) {
        this.statistics = statistics;
    }

    // 로또 발매기에서 로또 여러 장 뽑기
    public List<List<Integer>> buyLotto(int buyAmount) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < buyAmount / 1000; i++) {
            List<Integer> ticket = LottoGenerator.generateNumbers();
            lottoTickets.add(ticket);
        }

        return lottoTickets;
    }

    public List<String> calculateRanks(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber, int buyAmount) {
        for (List<Integer> ticketNumbers : lottoTickets) {
            Lotto lottoTicket = new Lotto(ticketNumbers);

            int regularMatchCount = lottoTicket.countRegularNumbers(winningNumbers);
            int bonusMatchCount = lottoTicket.countBonusNumber(bonusNumber);

            Rank rank = RankCalculator.calculateRank(regularMatchCount, bonusMatchCount);

            statistics.addRank(rank);
        }

        return statistics.getStatistics(buyAmount);
    }
}
