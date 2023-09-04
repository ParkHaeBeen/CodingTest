import java.util.*;
class Solution {
    static int [] combi=new int[2];
    static int[][] lines;
    static long maxY,maxX,minX,minY;

    static LinkedList<Spot> spots=new LinkedList<>();
    public static String[] solution(int[][] line) {
        String[] answer = {};
        lines=line;
        maxX=Long.MIN_VALUE;
        maxY=Long.MIN_VALUE;
        minX=Long.MAX_VALUE;
        minY=Long.MAX_VALUE;

        getCommonSpot();

        answer=new String[(int) (maxY-minY+1)];
        boolean[][] board = new boolean[(int) (maxY-minY+1)][(int) (maxX-minX+1)];

        for (Spot point : spots) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);

            board[y][x] = true;
        }
        int i = 0;
        for (boolean[] booleans : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : booleans) {
                if (b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[i++] = sb.toString();
        }

        return answer;
    }

    private static void getCommonSpot() {
        for(int li1=0;li1<lines.length-1;li1++) {
           for(int li2=li1+1;li2<lines.length;li2++) {
               long A = lines[li1][0];
               long B = lines[li1][1];
               long C = -lines[li1][2];

               long D = lines[li2][0];
               long E = lines[li2][1];
               long F = -lines[li2][2];

               long determinant = A * E - D * B;
               if (determinant == 0) continue;
               long x_upper = (C * E - F * B);
               long y_upper = (A * F - D * C);
               if (x_upper % determinant == 0 && y_upper % determinant == 0) {
                   long x = (C * E - F * B) / determinant;
                   long y = (A * F - D * C) / determinant;

                   spots.add(new Spot(x, y));
                   maxX = Math.max(maxX, x);
                   maxY = Math.max(maxY,  y);
                   minX = Math.min(minX,  x);
                   minY = Math.min(minY,y);

               }
           }
        }
    }

}
class Spot {
    long x,y,answer;

    public Spot(long  x, long y) {
        this.x = x;
        this.y = y;
    }

    public Spot(long x,long y, long  answer) {
        this.x = x;
        this.y = y;
        this.answer = answer;
    }
}
