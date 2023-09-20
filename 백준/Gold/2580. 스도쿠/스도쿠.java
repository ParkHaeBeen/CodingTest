import java.io.*;
import java.util.*;

class Main {
    static int N=9;
    static ArrayList<Point> zeros=new ArrayList<>();
    static int[][] result=new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] pan=new int[9][9];

        for(int i=0;i<9;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=0;k<9;k++){
                int num=Integer.parseInt(st.nextToken());
                pan[i][k]=num;
                if(num==0){
                    zeros.add(new Point(k,i));
                }
            }
        }

        getPan(pan,0);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        br.close();
    }

    private static void getPan(int[][] pan, int idx) {
        if(idx==zeros.size()){
            for(int i = 0; i < N; i++) {
                result[i] = pan[i].clone();
            }
            return;
        }
        for(int i=1;i<=9;i++){
            Point point=zeros.get(idx);
            if(possible(pan,i,point)){
                pan[point.y][point.x]=i;
                getPan(pan,idx+1);
                pan[point.y][point.x]=0;
            }
        }
    }

    private static boolean possible(int[][] pan, int value, Point point) {
        int x=point.x;
        int y=point.y;

        for(int i=0;i<N;i++) {
            if (pan[y][i] == value) {
                return false;
            }
        }


        for(int i=0;i<N;i++){

            if(pan[i][x]==value){
                return false;
            }
        }

        int startx=(x/3)*3;
        int starty=(y/3)*3;
        for(int i=0;i<3;i++){
            for(int k=0;k<3;k++){
                if(pan[starty+i][startx+k]==value){
                    return false;
                }
            }
        }

        return true;
    }
}
class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}