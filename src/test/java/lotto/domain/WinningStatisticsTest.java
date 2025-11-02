package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningStatisticsTest {
    @Test
    @DisplayName("3등 로또가 1개 당첨됨")
    void singleThird() {
        WinningStatistics statistics = new WinningStatistics(5000);
        statistics.addRank(Rank.THIRD);
        List<String> result = statistics.getStatistics();

        for (String count : result) {
            System.out.println(count);
        }
    }
}