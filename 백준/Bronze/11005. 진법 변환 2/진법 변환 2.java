import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Long N=Long.parseLong(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        String i = Long.toString(N,B);
        System.out.println(i.toUpperCase());
        br.close();
    }
}