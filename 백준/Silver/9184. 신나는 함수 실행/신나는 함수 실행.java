import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int[][][] num=new int[21][21][21];
        for(int i=0;i<21;i++){
            for(int k=0;k<21;k++){
                for(int h=0;h<21;h++){
                    if(i==0||k==0||h==0){
                        num[i][k][h]=1;
                    }
                }
            }
        }
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1&&c==-1){
                break;
            }
            sb.append("w("+a+", "+b+", "+c+") = ");
            boolean flag=false;
            if(a<=0||b<=0||c<=0){
                a=Math.max(a,0);
                b=Math.max(b,0);
                c=Math.max(c,0);
                a=Math.min(a,20);
                b=Math.min(b,20);
                c= Math.min(c,20);
                flag=true;
            }
            if((a>20||b>20||c>20)&&!flag){
                a=20;
                b=20;
                c=20;
            }

            int getpibo = getpibo(a, b, c, num);
            sb.append(getpibo+"\n");

        }
        StringBuilder delete = sb.delete(sb.length() - 1, sb.length());
        System.out.println(delete.toString().trim());
        br.close();

    }

    private static int getpibo(int a, int b, int c,int[][][]num) {
        if(num[a][b][c]!=0){
            return num[a][b][c];
        }

        if(a<b&&b<c){
            return num[a][b][c]=getpibo(a,b, Math.max(0,c-1),num)+getpibo(a,Math.max(0,b-1),Math.max(0,c-1),num)-getpibo(a,Math.max(0,b-1),c,num);
        }
         return num[a][b][c]=getpibo(Math.max(0,a-1),b,c,num)+getpibo(Math.max(0,a-1),Math.max(0,b-1),c,num)
                 +getpibo(Math.max(0,a-1),b,Math.max(0,c-1),num)-getpibo(Math.max(0,a-1),Math.max(0,b-1),Math.max(0,c-1),num);
    }
}