class Solution {
    static char[][] bd;
    static int[] dirX = new int[]{0,0,1,-1,1,-1,1,-1};
    static int[] dirY = new int[]{1,-1,0,0,1,1,-1,-1};
    static boolean owin;
    static boolean xwin;

    public int solution(String[] board) {
        int answer = 0;
        bd = new char[board.length][board[0].length()];
        int idx = 0;
        for (String bb : board) {
            for (int i = 0; i < bb.length(); i++) {
                char c = bb.charAt(i);
                bd[idx][i] = c;
            }
            idx++;
        }

        int ocnt = 0;
        int xcnt = 0;
        for (int i = 0; i < bd.length; i++) {
            for (int k = 0; k < bd.length; k++) {
                if (bd[i][k] == 'O') {
                    find(k, i, bd[i][k]);
                    ocnt++;
                } else if (bd[i][k] == 'X') {
                    find(k, i, bd[i][k]);
                    xcnt++;
                }
            }
        }
        
        if (owin && xwin) return answer;
        else if (owin) {
            if (xcnt == ocnt - 1) answer = 1;
        } else if (xwin) {
            if (ocnt == xcnt) answer = 1;
        } else {
            if (ocnt == xcnt || ocnt == xcnt + 1) {
                answer = 1;
            }
        }

        return answer;
    }

    private static void find(int x, int y, char c) {
        for (int i = 0; i < 8; i++) {
            int cnt = 1;  // Start with 1 considering the starting point itself
            int newX = x;
            int newY = y;
            while (true) {
                newX = newX + dirX[i];
                newY = newY + dirY[i];
                if (newX < 0 || newY < 0 || newY >= 3 || newX >= 3) break;
                if (bd[newY][newX] == c) {
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt == 3) {
                if (c == 'O') {
                    owin = true;
                } else {
                    xwin = true;
                }
                return; 
            }
        }
    }
}