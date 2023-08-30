
import java.io.*;
import java.util.*;

public class Main{
    static int N,S,answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        answer=0;
        getCount(0,0);

        System.out.println(answer);
        br.close();
    }

    private static void getCount(int idx,long sum){
        if(sum==S&&idx!=0){
            answer++;
        }

        for(int i=idx;i<arr.length;i++){
            getCount(i+1,sum+arr[i]);
        }
    }
}
