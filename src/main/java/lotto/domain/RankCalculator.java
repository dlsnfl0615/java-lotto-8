package lotto.domain;

public class RankCalculator {
    public static Rank calculateRank(int regularCount, int bonusCount) {
        if (regularCount == 6 && bonusCount == 0) {
            return Rank.FIRST;
        }
        if (regularCount == 5 && bonusCount == 1) {
            return Rank.SECOND;
        }
        if (regularCount == 5 && bonusCount == 0) {
            return Rank.THIRD;
        }
        if (regularCount == 4 && bonusCount == 0) {
            return Rank.FOURTH;
        }
        if (regularCount == 3 && bonusCount == 0) {
            return Rank.FIFTH;
        }
        return Rank.FAIL;
    }
}
