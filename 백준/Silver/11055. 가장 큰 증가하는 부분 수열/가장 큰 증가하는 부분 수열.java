import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[]dp=new int[N];

        dp[0]=arr[0];

        for(int i=1;i<N;i++){
            for(int k=i-1;k>=0;k--){
                if(arr[i]>arr[k]){
                    dp[i]=Math.max(dp[i],dp[k]+arr[i]);
                }
            }
            if(dp[i]==0){
                dp[i]=arr[i];
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
        br.close();
    }
}