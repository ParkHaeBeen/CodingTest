import java.io.*;
import java.util.*;

public class Main {

    static int N,K,answer;
    static boolean[] check;
    static int[] arr=new int[]{1,-1,2};
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        check=new boolean[100000*2+10];

        answer=Integer.MAX_VALUE;
        findMinTime();

        if(answer==Integer.MAX_VALUE){
            System.out.println(N);
        }else{
            System.out.println(answer);
        }
        br.close();
    }

    private static   void findMinTime() {
        PriorityQueue<DisTime> pq=new PriorityQueue<>();
        pq.add(new DisTime(N,0));

        while(!pq.isEmpty()){
            DisTime now = pq.poll();
            int start=now.now;
            int sumTime=now.time;
            if(start==K){
                answer=Math.min(answer,sumTime);
                break;
            }

            if (start <0 || start > 200000 ||check[start]) continue;
            check[start]=true;
            for (int i = 0; i < 3; i++) {
                if (i == 2&&start*arr[i]!=0&&start*2<=2*K) {
                    pq.add(new DisTime(start * arr[i], sumTime));
                } else {
                    pq.add(new DisTime(start + arr[i], sumTime + 1));
                }
            }

        }
    }

}
class DisTime implements Comparable<DisTime>{
    int now,time;

    public DisTime(int now, int time) {
        this.now = now;
        this.time = time;
    }

    @Override
    public int compareTo(DisTime o) {
        return this.time-o.time;
    }
}