package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {
    @ParameterizedTest
    @DisplayName("3등, 4등, 5등 테스트")
    @ValueSource(ints = {3,4,5})
    void thirdFourthFifth(int argument) {
        Rank[] ranks = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD};
        assertThat(RankCalculator.calculateRank(argument, 0)).isEqualTo(ranks[argument - 3]);
    }

    @Test
    @DisplayName("1등 테스트")
    void first() {
        assertThat(RankCalculator.calculateRank(6, 0)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 테스트")
    void second() {
        assertThat(RankCalculator.calculateRank(5, 1)).isEqualTo(Rank.SECOND);
        assertThat(RankCalculator.calculateRank(5, 0)).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @DisplayName("하나도 당첨 안 된 경우")
    @ValueSource(ints = {0, 1, 2})
    void fail(int argument) {
        assertThat(RankCalculator.calculateRank(argument, 0)).isEqualTo(Rank.FAIL);
    }
}