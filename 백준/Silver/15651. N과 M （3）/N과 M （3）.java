import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[M];
        getCombi(0);

        System.out.println(sb.toString());
        br.close();
    }

    private static void getCombi(int L) {
        if(L==M){
            StringBuilder sb2=new StringBuilder();
            for (int i : arr) {
                sb2.append(i+" ");
            }
            sb.append(sb2.toString().trim());
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
                arr[L] = i;
                getCombi(L + 1);
        }
    }
}
