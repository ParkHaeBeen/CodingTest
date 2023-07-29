import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int MAX;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        MAX=N+1;
        map=new int[MAX][MAX];
        visited=new boolean[MAX][MAX];

        for(int i=1;i<=N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int k=1;k<=N;k++){
                map[i][k]=Integer.parseInt(st.nextToken());
            }
        }

        answer="Hing";
        dfs(1,1);

        bw.write(answer);

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {
        int grade=map[y][x];
        
        if(map[y][x]==-1){
            answer="HaruHaru";
            return;
        }else if(y+grade>=MAX&&x+grade>=MAX||grade==0){
            return;
        }

        if(y+grade<MAX){
            dfs(y+grade,x);
        }
        if(x+grade<MAX){
            dfs(y,x+grade);
         }
    }
}
