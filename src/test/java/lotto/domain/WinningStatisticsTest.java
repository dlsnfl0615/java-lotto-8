package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    @Test
    void 로또_3등_당첨() {
        WinningStatistics statistics = new WinningStatistics();
        statistics.addRank(Rank.THIRD);
        List<String> result = statistics.getStatistics(5000);

        assertThat(result).containsExactly("0", "0", "1", "0", "0", "30000.0");
    }
}