import java.io.*;
import java.util.*;
public class Main{
    static int N,M,K;
    static int[][] A,B,answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                A[i][k]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        B=new int[M][K];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<K;k++){
                B[i][k]=Integer.parseInt(st.nextToken());
            }
        }

         answer=new int[N][K];
        for(int i=0;i<N;i++){
            for(int h=0;h<K;h++) {

                for (int k = 0; k < M; k++) {
                    answer[i][h] += A[i][k] * B[k][h];
                }

            }


        }

        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

        br.close();
    }
}
