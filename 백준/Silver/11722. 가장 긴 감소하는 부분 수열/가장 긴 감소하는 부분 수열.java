import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[] arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[N];
        Arrays.fill(dp,1);
        for(int i=0;i<N;i++){
            for(int k=i-1;k>=0;k--){
                if(arr[i]<arr[k]){
                    dp[i]=Math.max(dp[k]+1,dp[i]);
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}
