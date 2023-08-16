import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int answer = find(K, arr);
        System.out.println(answer);
        br.close();
    }

    private static int find(int k, int[] arr) {
        int start=1;
        int end=k;
        int max=0;
        for(int i=0;i<k;i++){
            max+=arr[i];
        }
        int sum=max;
        while(end<=arr.length-1){
            int num=sum-arr[start-1]+arr[end];
            sum=num;
            if(num>max) max=num;
            start++;
            end++;
        }

        return max;
    }
}
