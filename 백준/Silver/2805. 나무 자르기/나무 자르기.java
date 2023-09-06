import java.io.*;
import java.util.*;
public class Main {
    static long N,M;
    static long[] woods;
    static long answer=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        long maxLength=Integer.MIN_VALUE;
        woods=new long[(int)N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            woods[i]=Integer.parseInt(st.nextToken());
            maxLength=Math.max(maxLength,woods[i]);
        }

        getMaxHeight(0,maxLength);
        System.out.println(answer);
        br.close();
    }

    private static void getMaxHeight(long i, long maxLength) {
        if(i>maxLength){
            return;
        }

        long mid=(i+maxLength)/2;
        long sum=0;
        for (long wood : woods) {
            sum+=Math.max(wood-mid,0);
        }

        if(sum<M){
            getMaxHeight(i,mid-1);
        }else if(sum>M){
            answer=Math.max(answer,mid);
            getMaxHeight(mid+1,maxLength);
        }else if(sum==M){
            answer=Math.max(answer,mid);
        }
    }
}
