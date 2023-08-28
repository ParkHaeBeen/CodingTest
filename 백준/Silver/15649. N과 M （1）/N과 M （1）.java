import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[M];
        visited=new boolean[N+1];
        getCombi(0);
    }

    private static void getCombi(int L) {
        if(L==M){
            StringBuilder sb=new StringBuilder();
            for (int i : arr) {
                sb.append(i+" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i=1;i<=N;i++){
            if(visited[i]==false) {
                arr[L] = i;
                visited[i]=true;
                getCombi(L + 1);
                visited[i]=false;
            }
        }
    }
}
