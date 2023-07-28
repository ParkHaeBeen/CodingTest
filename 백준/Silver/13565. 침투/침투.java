import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int MAX=1000+10;
    static boolean [][] map;
    static int M,N;

    static int[] dirY={1,-1,0,0};
    static int[] dirX={0,0,1,-1};
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new boolean[MAX][MAX];

        for(int i=1;i<=M;i++){
            String next=br.readLine();
            String[] check = next.split("");
            for(int k=1;k<=N;k++){
                if(check[k-1].equals("0")) {
                    map[i][k] = true;
                }
            }
        }
        answer="NO";
        for(int i=1;i<=N;i++){
            if(map[1][i]==true){
                dfs(1,i);
            }
        }

        bw.write(answer);

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {
        map[y][x]=false;

        if(y==M){
            answer="YES";
            return;
        }

        for(int i=0;i<4;i++){
            int newy=y+dirY[i];
            int newx=x+dirX[i];

            if(map[newy][newx]){
                dfs(newy,newx);
            }
        }

    }
}
