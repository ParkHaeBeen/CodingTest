import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Bus> list=new ArrayList<>();
    static long[] dis;
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        dis=new long[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1]=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());

            list.add(new Bus(start,end, time));
        }

        findMin(N,M);

        if(answer==true){
            System.out.println(-1);
        }else{
            for(int i=2;i<=N;i++){
                if(dis[i]==Integer.MAX_VALUE){
                    System.out.println(-1);
                }else{
                    System.out.println(dis[i]);
                }
            }
        }
        br.close();
    }

    private static void findMin(int n,int m) {

        for(int i=0;i<n;i++){
            for(int k=0;k<m;k++){
                Bus bus = list.get(k);
                if(dis[bus.start]!=Integer.MAX_VALUE&&dis[bus.end]>dis[bus.start]+bus.time){
                    dis[bus.end]=dis[bus.start]+bus.time;
                }
            }
        }

        for(int i=0;i<m;i++){
            Bus bus = list.get(i);
            if(dis[bus.start]!=Integer.MAX_VALUE&&dis[bus.end]>dis[bus.start]+bus.time){
                answer=true;
                break;
            }
        }
    }

}

class Bus{
    int start,end,time;

    public Bus(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}