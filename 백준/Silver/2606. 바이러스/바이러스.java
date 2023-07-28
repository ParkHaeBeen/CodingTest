import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] graph;
    static boolean[] visited;

    static int N,M;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        graph=new boolean[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=M;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            graph[x][y]=true;
            graph[y][x]=true;
        }

        count=0;
        dfs(1);

        bw.write(String.valueOf(count));

        br.close();
        bw.close();

    }

    private static void dfs(int idx) {
        visited[idx]=true;

        for(int i=1;i<=N;i++){
            if(graph[idx][i]==true&&visited[i]==false){
                count++;
                dfs(i);
            }
        }
    }
}
