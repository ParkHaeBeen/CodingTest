import java.io.*;
import java.util.*;
public class Main {

    static int N;
    static int[][] video;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        video=new int[N][N];
        for(int i=0;i<N;i++) {
            String next=br.readLine();
            for(int k=0;k<N;k++){
                video[i][k]=next.charAt(k)-'0';
            }
        }
        StringBuilder sb=new StringBuilder();
        //sb.append("(");
        getVideo(0,0,N,sb);
        System.out.println(answer.toString());
        br.close();
    }

    private static void getVideo(int y, int x, int n,StringBuilder sb) {

        if(getCheck(y,x,n)){
            sb.append(video[y][x]);
            answer=sb;
            return;
        }

        int next=n/2;
        sb.append("(");
        getVideo(y,x,next,sb);
        getVideo(y,x+next,next,sb);
        getVideo(y+next,x,next,sb);
        getVideo(y+next,x+next,next,sb);
        sb.append(")");
    }

    private static boolean getCheck(int y, int x, int n) {
        int start=video[y][x];
        for(int i=y;i<y+n;i++){
            for(int k=x;k<x+n;k++){
                if(video[i][k]!=start){
                    return false;
                }
            }
        }
        return true;
    }
}
