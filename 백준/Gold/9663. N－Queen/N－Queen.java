import java.io.*;
import java.util.*;

public class Main {

    static int N,answer;
    static int[][] dir={{1,1},{1,-1},{-1,-1},{-1,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        boolean[][]ches=new boolean[N][N];
        answer=0;
        getQueenCount(0,ches,0);
        System.out.println(answer);
        br.close();
    }

    private static void getQueenCount(int queen,boolean[][] ches,int depth) {
        if(queen==N){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){
            if (getQueenCon(ches, i, depth)) {
                ches[depth][i] = true;
                getQueenCount(queen + 1, ches,depth+1);
                ches[depth][i] = false;
            }
        }
    }

    private static boolean getQueenCon(boolean[][] ches, int i, int k) {
        for(int h=0;h<N;h++){
            if(ches[k][h]){
                return false;
            }

            if(ches[h][i]){
                return false;
            }
        }

        for (int[] ints : dir) {
            if(i+ints[0]<0||i+ints[0]>=N||k+ints[1]<0||k+ints[1]>=N) continue;
            int y=i+ints[0];
            int x=k+ints[1];
            while(x>0||x<N||y>0||y<N){
                if(ches[x][y]) return false;
                y+=ints[0];
                x+=ints[1];

                if(x<0||x>=N||y<0||y>=N){
                    break;
                }
            }
        }

        return true;
    }
}