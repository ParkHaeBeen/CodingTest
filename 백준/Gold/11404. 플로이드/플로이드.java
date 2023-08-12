import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        K=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];
        for (int i = 1 ; i <= N ; i ++) {
            Arrays.fill(arr[i],Integer.MAX_VALUE);
            arr[i][i]=0;
        }
        for(int i=0;i<K;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

           if(arr[n][k]>cost){
               arr[n][k]=cost;
           }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE
                            && arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

       for(int i=1;i<=N;i++){
           StringBuilder sb= new StringBuilder();
           for(int k=1;k<=N;k++){
               if(arr[i][k]==Integer.MAX_VALUE){
                   sb.append(0+" ");
               }else {
                   sb.append(arr[i][k]+" ");
               }
           }
           System.out.println(sb.toString().trim());
       }


    }
}
