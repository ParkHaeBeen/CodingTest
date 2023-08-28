import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[M];
        getCombi(0,1);
    }

    private static void getCombi(int L,int idx) {
        if(L==M){
            StringBuilder sb=new StringBuilder();
            for (int i : arr) {
                sb.append(i+" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i=idx;i<=N;i++){
                arr[L] = i;
                getCombi(L + 1,i+1);

        }
    }
}
