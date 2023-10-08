import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[]arr=new int[N];

        if(N==1){
            System.out.println(1);
            System.exit(0);
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] memo=new int[N];
        int idx=0;
        for(int i=0;i<N;i++){
            if(arr[i]>memo[idx]){
                memo[++idx]=arr[i];
            }else{
                int insertIDx = biSearch(0, idx, arr[i], memo);
                memo[insertIDx]=arr[i];
            }
        }

        System.out.println(idx);
    }

    private static int biSearch(int start, int end, int num,int[] memo) {

        int mid=0;

        while(start<=end){
            mid=(start+end)/2;

            if(memo[mid]<num){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }

        return start;

    }

}