import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[M];
        visited=new boolean[N+1];
        getCombi(0,1);

        System.out.println(sb.toString());
        br.close();
    }

    private static void getCombi(int L,int idx) {
        if(L==M){
            StringBuilder sb2=new StringBuilder();
            for (int i : arr) {
                sb2.append(i+" ");
            }
            sb.append(sb2.toString().trim());
            sb.append('\n');
            return;
        }
        for(int i=idx;i<=N;i++){
                arr[L] = i;
                getCombi(L + 1,i);
        }
    }
}
