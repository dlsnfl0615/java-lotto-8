package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void 테스트_3등_4등_5등(int argument) {
        Rank[] ranks = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD};
        assertThat(RankCalculator.calculateRank(argument, 0)).isEqualTo(ranks[argument - 3]);
    }

    @Test
    void 테스트_1등() {
        assertThat(RankCalculator.calculateRank(6, 0)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 테스트_2등() {
        assertThat(RankCalculator.calculateRank(5, 1)).isEqualTo(Rank.SECOND);
        assertThat(RankCalculator.calculateRank(5, 0)).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨안된경우(int argument) {
        assertThat(RankCalculator.calculateRank(argument, 0)).isEqualTo(Rank.FAIL);
    }
}