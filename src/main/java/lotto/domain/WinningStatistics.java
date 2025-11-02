package lotto.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningStatistics {
    private final Map<Rank, Integer> winningCount = new HashMap<>();

    public WinningStatistics() {
        winningCount.put(Rank.FIRST, 0);
        winningCount.put(Rank.SECOND, 0);
        winningCount.put(Rank.THIRD, 0);
        winningCount.put(Rank.FOURTH, 0);
        winningCount.put(Rank.FIFTH, 0);
        winningCount.put(Rank.FAIL, 0);
    }

    public void addRank(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public List<String> getStatistics(int buyAmount) {
        List<String> result = new ArrayList<>();

        result.add(winningCount.get(Rank.FIFTH).toString());
        result.add(winningCount.get(Rank.FOURTH).toString());
        result.add(winningCount.get(Rank.THIRD).toString());
        result.add(winningCount.get(Rank.SECOND).toString());
        result.add(winningCount.get(Rank.FIRST).toString());

        result.add(getReturnRate(buyAmount));

        return result;
    }

    public String getReturnRate(int buyAmount) {
        double sum = 0;
        Set<Rank> keySet = winningCount.keySet();
        for (Rank rank : keySet) {
            sum += winningCount.get(rank) * rank.getMoney();
        }

        return String.format("%.1f", sum / buyAmount * 100);
    }
}
