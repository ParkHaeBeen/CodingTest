import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] dp=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            if(i==0){
                dp[i][i]=Integer.parseInt(st.nextToken());
            }else{
                dp[i][0]=dp[i-1][0]+Integer.parseInt(st.nextToken());

                for(int k=1;k<i;k++){
                    dp[i][k]=Math.max(dp[i-1][k-1],dp[i-1][k])+Integer.parseInt(st.nextToken());
                }

                dp[i][i]=dp[i-1][i-1]+Integer.parseInt(st.nextToken());
            }

        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max=Math.max(max,dp[N-1][i]);
        }

        System.out.println(max);
        br.close();
    }
}
