import java.io.*;
import java.util.StringTokenizer;

class Main {

    final static int MAX=1000+10;
    static boolean[][] graph;
    static boolean[] visited;
    static int N,M;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st1.nextToken());
        M=Integer.parseInt(st1.nextToken());

        //N+1 / N+!로 해도 되지만 넉넉하기 MAX
        graph=new boolean[N+1][N+1];
        visited=new boolean[N+1];

        //1.graph에 연결정보 채우기
        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y]=true;
            graph[y][x]=true;
        }

        //재귀함수 호출

        for(int i=1;i<=N;i++) {
            if(visited[i]==false) {
                dfs(i);
                answer++;
            }

        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

    private static void dfs(int i) {
        visited[i]=true;
        
        for(int k=1;k<=N;k++){
            if(graph[i][k]==true&&visited[k]==false){
                dfs(k);
            }
        }
    }
}
