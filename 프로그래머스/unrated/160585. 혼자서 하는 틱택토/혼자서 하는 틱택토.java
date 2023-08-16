import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    private static final Character O = 'O';
    private static final Character X = 'X';
    public int solution(String[] board) {
        Map<Character, Long> counts = Arrays.stream(board)
                .flatMap(row -> row.chars()
                        .mapToObj(word -> (char) word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int xCount = counts.getOrDefault(X, 0L).intValue();
        int oCount = counts.getOrDefault(O, 0L).intValue();

        if (xCount > oCount || oCount - xCount > 1) {
            return 0;
        }

        boolean xWin = checkWin(board, X);
        boolean oWin = checkWin(board, O);

        if (xWin && oWin) {
            return 0;
        }

        if (xWin && oCount > xCount ||
                oWin && xCount >= oCount) {
            return 0;
        }

        return 1;
    }

    private boolean checkWin(String[] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == symbol && board[i].charAt(1) == symbol && board[i].charAt(2) == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == symbol && board[1].charAt(i) == symbol && board[2].charAt(i) == symbol) {
                return true;
            }
        }

        if (board[0].charAt(0) == symbol && board[1].charAt(1) == symbol && board[2].charAt(2) == symbol) {
            return true;
        }

        return board[0].charAt(2) == symbol && board[1].charAt(1) == symbol && board[2].charAt(0) == symbol;
    }
}
