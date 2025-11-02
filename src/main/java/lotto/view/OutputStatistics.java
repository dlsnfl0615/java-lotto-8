package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class OutputStatistics {
    private final String BUY_AMOUNT = "개를 구매했습니다.";
    private final String HEADER = "당첨 통계";
    private final String LINE = "---";
    private final String FIFTH_PLACE = "3개 일치 (5,000원) - ";
    private final String FOURTH_PLACE = "4개 일치 (50,000원) - ";
    private final String THIRD_PLACE = "5개 일치 (1,500,000원) - ";
    private final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - ";
    private final String UNIT = "개";
    private final String RETURN_RATE = "총 수익률은 ";
    private final String PERCENT = "%입니다.";

    public void printLottoTickets(List<List<Integer>> lottoTickets, int buyAmount) {
        List<String> merged = mergeNumbers(lottoTickets);

        System.out.println(buyAmount / 1000 + BUY_AMOUNT);

        for (String numbers : merged) {
            System.out.println(numbers);
        }
    }

    public List<String> mergeNumbers(List<List<Integer>> lottoTickets) {
        List<String> result = new ArrayList<>();
        for (List<Integer> ticket : lottoTickets) {
            result.add(ticket.toString());
        }

        return result;
    }

    public void printResult(List<String> statistics) {
        System.out.println(HEADER);
        System.out.println(LINE);
        System.out.println(FIFTH_PLACE + statistics.get(0) + UNIT);
        System.out.println(FOURTH_PLACE + statistics.get(1) + UNIT);
        System.out.println(THIRD_PLACE + statistics.get(2) + UNIT);
        System.out.println(SECOND_PLACE + statistics.get(3) + UNIT);
        System.out.println(FIRST_PLACE + statistics.get(4) + UNIT);
        System.out.println(RETURN_RATE + statistics.get(5) + PERCENT);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
