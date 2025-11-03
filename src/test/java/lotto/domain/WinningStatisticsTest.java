package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    @ParameterizedTest()
    @MethodSource("ranks")
    void 모든_등수_하나씩_당첨(List<String> output, Rank rank) {
        WinningStatistics statistics = new WinningStatistics();
        statistics.addRank(rank);
        List<String> result = statistics.getStatistics(1000);

        assertThat(result).isEqualTo(output);
    }

    static Stream<Arguments> ranks() {
        return Stream.of(
                Arguments.of(List.of("1", "0", "0", "0", "0", "500.0"), Rank.FIFTH),
                Arguments.of(List.of("0", "1", "0", "0", "0", "5000.0"), Rank.FOURTH),
                Arguments.of(List.of("0", "0", "1", "0", "0", "150000.0"), Rank.THIRD),
                Arguments.of(List.of("0", "0", "0", "1", "0", "3000000.0"), Rank.SECOND),
                Arguments.of((List.of("0", "0", "0", "0", "1", "200000000.0")), Rank.FIRST)
        );
    }
}