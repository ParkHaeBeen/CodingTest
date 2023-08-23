import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] dis;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        dis=new int[N+1][N+1];
        for (int[] di : dis) {
            Arrays.fill(di,Integer.MAX_VALUE);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int user1=Integer.parseInt(st.nextToken());
            int user2=Integer.parseInt(st.nextToken());

            dis[user1][user2]=1;
            dis[user2][user1]=1;
        }

        findMinKevin();

        answer=new int[N+1];
        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                if(i!=k) {
                    answer[i] += dis[i][k];
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for (int i=1;i<=N;i++) {
            if(min>answer[i]){
                min=answer[i];
            }
        }

        int result=0;
        for (int i=1;i<=N;i++) {
            if(min==answer[i]){
                result=i;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void findMinKevin() {
        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                for(int h=1;h<=N;h++){
                    if(dis[k][i]!=Integer.MAX_VALUE&&dis[i][h]!=Integer.MAX_VALUE&&dis[k][h]>dis[k][i]+dis[i][h]){
                        dis[k][h]=dis[k][i]+dis[i][h];
                    }
                }
            }
        }
    }
}
