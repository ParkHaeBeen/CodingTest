import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int[][] paper;
    static int minusOne,zero,one;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        paper=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                paper[i][k]=Integer.parseInt(st.nextToken());
            }
        }
        getPaperCount(0,0,N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
        br.close();
    }

    private static void getPaperCount(int x, int y, int length) {

        int start=paper[y][x];
        boolean flag=true;
        Loop:
        for(int i=y;i<y+length;i++){
            for(int k=x;k<x+length;k++){
                if(paper[i][k]!=start){
                    flag=false;
                    break Loop;
                }
            }
        }

        if(flag){
            if(start==-1){
                minusOne++;
            }else if(start==0){
                zero++;
            }else{
                one++;
            }
            return;
        }
        int next=length/3;
        getPaperCount(x,y,next);
        getPaperCount(x+next,y,next);
        getPaperCount(x+2*next,y,next);
        getPaperCount(x,y+next,next);
        getPaperCount(x,y+2*next,next);
        getPaperCount(x+next,y+next,next);
        getPaperCount(x+next,y+2*next,next);
        getPaperCount(x+2*next,y+next,next);
        getPaperCount(x+2*next,y+2*next,next);
    }
}
