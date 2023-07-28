
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int MAX=50+10;
    static boolean[][] map;
    static int N,M;

    static int[] dirY={1,-1,1,-1,-1,1,0,0};
    static int[] dirX={1,1,-1,-1,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            map=new boolean[MAX][MAX];

            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            if(N==0&&M==0){
                break;
            }

            for(int i=1;i<=M;i++){
                st=new StringTokenizer(br.readLine());
                for(int k=1;k<=N;k++){
                    map[i][k]=Integer.parseInt(st.nextToken())==1;
                }
            }

            int answer=0;
            for(int i=1;i<=M;i++){
                for(int k=1;k<=N;k++){
                    if(map[i][k]){
                        answer++;
                        dfs(i,k);
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {
        map[y][x]=false;

        for(int i=0;i< dirY.length;i++){
            int newY=y+dirY[i];
            int newX=x+dirX[i];

            if(map[newY][newX]){
                dfs(newY,newX);
            }

        }
    }
}
