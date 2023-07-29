import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;

    static int N,M,answer;
    static boolean[][] visited;
    static int dir=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N+10][M+10];
        visited=new boolean[N+10][M+10];
        for(int i=1;i<=N;i++){
            String tiles = br.readLine();
            for(int k=1;k<=M;k++){

                map[i][k]=tiles.charAt(k-1);

            }
        }

        answer=0;
        for(int i=1;i<=N;i++){
            for(int k=1;k<=M;k++) {
                if(visited[i][k]==false) { 
                    dfs(i, k);
                    answer++;
                }

            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();

    }

    private static void dfs(int y,int x) {
        visited[y][x]=true; 


        if(map[y][x]=='-'&&map[y][x+1]=='-'){
            dfs(y,x+1);
        }
        if(map[y][x]=='|'&&map[y+1][x]=='|'){
            dfs(y+1,x);
        }


    }

}
