import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static long S;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        S=Long.parseLong(st.nextToken());
        
        arr=new long[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        long sum = 0;
        answer = Integer.MAX_VALUE;

        while(true) {
            if(sum >= S) {
                answer = Math.min(answer, end-start);
                sum -= arr[start++];
            } else if(end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}