
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[][]arr=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int g=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[i][0]=r;
            arr[i][1]=g;
            arr[i][2]=b;

        }

        for(int i=1;i<N;i++){
            arr[i][0]+=Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1]+=Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2]+=Math.min(arr[i-1][0],arr[i-1][1]);
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<=2;i++){
            min=Math.min(arr[N-1][i],min);
        }

        System.out.println(min);
        br.close();
    }
}