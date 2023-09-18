import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String N=st.nextToken();
        int B=Integer.parseInt(st.nextToken());

        int i = Integer.parseInt(N, B);
        System.out.println(i);
        br.close();
    }
}