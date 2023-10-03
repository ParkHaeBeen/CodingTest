import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        long [] arr=new long[101];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        StringBuilder sb=new StringBuilder();
        while (T-->0){
            int N=Integer.parseInt(br.readLine());

            for(int i=4;i<=N;i++){
                arr[i]=arr[i-2]+arr[i-3];
            }

            sb.append(arr[N]);
            if(T>=1){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
