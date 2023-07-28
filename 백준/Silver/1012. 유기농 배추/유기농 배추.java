
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    final  static int MAX = 50+10;
    static boolean map[][];
    static boolean visited[][];
    static int T,N,M,K;

    static int[] dirY={-1,1,0,0};
    static int[] dirX={0,0,-1,1};

    private static void dfs(int y, int x) {
        visited[y][x]=true;

        for(int h=0;h<4;h++){
            int newY=y+dirY[h];
            int newX=x+dirX[h];

            if(visited[newY][newX]==false&&map[newY][newX]){
                dfs(newY,newX);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(br.readLine());



        while(T-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());

            map=new boolean[MAX][MAX];
            visited=new boolean[MAX][MAX];

            //1.map정보 반영
            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());

                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());


                map[y+1][x+1]=true;
            }

            //2.dfs
            int answer=0;
            for(int i=1;i<=N;i++){
                for(int k=1;k<=M;k++){
                    if(map[i][k]&&visited[i][k]==false){
                        answer++;
                        dfs(i,k);
                    }
                }
            }

            //3.출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }


        br.close();
        bw.close();
    }


}
