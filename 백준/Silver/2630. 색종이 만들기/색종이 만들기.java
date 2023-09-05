import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int white,blue;
    static boolean[][] paper,visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        paper=new boolean[N][N];
        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                int num=Integer.parseInt(st.nextToken());
                if(num==0){
                    paper[i][k]=true; //하얀
                }else{
                    paper[i][k]=false; //파란
                }
            }
        }

        white=0;
        blue=0;
        getPaperCount(0,0,N);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    private static void getPaperCount(int i, int h, int length) {

        boolean color=paper[i][h];
        boolean check=true;
        Loop:
       for(int k=i;k<i+length;k++){
           for(int g=h;g<h+length;g++){
               if(color!=paper[k][g]){
                   check=false;
                   break Loop;
               }
           }
       }

       if(check){
           if(color==true){
               white++;
           }else if(color==false){
               blue++;
           }
           return;
       }
       getPaperCount(i,h,length/2);
       getPaperCount(i+(length/2),h,length/2);
       getPaperCount(i,h+(length/2),length/2);
       getPaperCount(i+(length/2),h+(length/2),length/2);
    }
}
