
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    final static int MAX=100+10;
    static boolean[][] graph;
    static boolean [] visited;
    static int N,M,start,end,answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());

        M=Integer.parseInt(br.readLine());

        //1.graph 공간채우기
        graph=new boolean[MAX][MAX];
        visited=new boolean[MAX];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            graph[x][y]=true;
            graph[y][x]=true;

        }

        answer=-1;
        //2.dfs 구현

        dfs(start,0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();

    }

    private static void dfs(int start, int count) {
        visited[start]=true;

        if(start==end){
            answer=count;
            return;
        }

        for(int i=1;i<=N;i++){
            if(visited[i]==false&&graph[start][i]){
                dfs(i,count+1);
            }
        }

    }
}
