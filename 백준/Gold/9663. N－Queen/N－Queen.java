import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());


        for(int x=0;x<N;x++){
            boolean[][] map=new boolean[N][N];
            map[0][x]=true;
            getQueen(map,1,0);
        }

        System.out.println(answer);
        br.close();
    }

    private static void getQueen(boolean[][] map, int y,int cnt) {
        if(y==N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            if(possible(i,y,map)){
                map[y][i]=true;
                getQueen(map,y+1,cnt+1);
                map[y][i]=false;
            }
        }
    }

    private static boolean possible(int x, int y, boolean[][] map) {
        //x축들 확인
        for(int i=0;i<N;i++) {
            if (map[i][x]) {
                return false;
            }
        }
        //기울기 위로
        int newX=x-1;
        int newY=y-1;
        while(true){
            if(newX<0||newX>=N||newY<0||newY>=N) break;
            if(map[newY][newX]){
                return false;
            }
            newX--;
            newY--;
        }

        newX=x+1;
        newY=y-1;
        while(true){
            if(newX<0||newX>=N||newY<0||newY>=N) break;
            if(map[newY][newX]){
                return false;
            }
            newX++;
            newY--;
        }

        return true;
    }
}