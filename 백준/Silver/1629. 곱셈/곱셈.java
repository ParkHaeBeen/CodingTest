import java.io.*;
import java.util.*;
public class Main {

    static int A,B,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long pow = getPow(A, B, C);
        System.out.println(pow);
        br.close();
    }

    private static long getPow(int a, int b, int c) {
        if(b==1){
            return a%c;
        }

        long num = getPow(a, b / 2, c);

        if(b%2==1){
            return (num*num)%c*a%c;
        }else{
            return num*num%c;
        }
    }
}
