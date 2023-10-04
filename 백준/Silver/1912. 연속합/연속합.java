import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[] arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max=Integer.MIN_VALUE;
        int sum=0;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            sum+=arr[i];
            if(sum>=0){
                max=Math.max(max,sum);
            }else{
                sum=0;
            }
            min=Math.max(min,arr[i]);
        }

        if(max==Integer.MIN_VALUE){
            System.out.println(min);
            System.exit(0);
        }

        System.out.println(max);
        br.close();
    }
}