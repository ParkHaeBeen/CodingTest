

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int num = find(A, B);
            list.add(A*B/num);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
        br.close();
    }

    private static int find(int a, int b) {
        if(a%b==0){
            return b;
        }

        return find(b,a%b);
    }
}
