import java.io.*;
import java.util.*;
public class Main {

    static int ax,ay,bx,by,ac,bf;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        ax=Integer.parseInt(st.nextToken());
        ay=Integer.parseInt(st.nextToken());
        ac=Integer.parseInt(st.nextToken());
        bx=Integer.parseInt(st.nextToken());
        by=Integer.parseInt(st.nextToken());
        bf=Integer.parseInt(st.nextToken());

        int xanswer=0;
        int yanswer=0;
        if(ax==0){
            yanswer=ac/ay;
            xanswer=(bf-by*yanswer)/bx;
        }else if(ay==0){
            xanswer=ac/ax;
            yanswer=(bf-bx*xanswer)/by;
        }else if(bx==0){
            yanswer=bf/by;
            xanswer=(ac-ay*yanswer)/ax;
        }else if(by==0){
            xanswer=bf/bx;
            yanswer=(ac-ax*xanswer)/ay;
        }else if(ax==bx){
            int y=ay-by;
            int answer=ac-bf;
            yanswer=answer/y;
            xanswer=(ac-ay*yanswer)/ax;
        }else if(ay==by){
            int x=ax-bx;
            int answer=ac-bf;
            xanswer=answer/x;
            yanswer=(ac-ax*xanswer)/ay;
        }else{
            int min = getMin(ax, bx);
            int num1=min/ax;
            int num2=min/bx;

            int y1=ay*num1;
            int y2=by*num2;
            int answer1=ac*num1;
            int answer2=bf*num2;

            yanswer=(answer1-answer2)/(y1-y2);
            xanswer=(ac-ay*yanswer)/ax;
        }

        System.out.println(xanswer+" "+yanswer);
        br.close();
    }

    private static int getMin(int ax, int bx) {
        int gcd = getGCD(ax, bx);

        return (ax*bx)/gcd;
    }

    private static int getGCD(int ax, int bx) {
        if(ax%bx==0){
            return bx;
        }

        return getGCD(bx,ax%bx);
    }
}