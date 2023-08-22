
import java.io.*;
import java.util.*;

public class Main {

    static int N,M,W;
    static int[]arr;
    static ArrayList<TimeTravel> list;
    static boolean answer=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        while(TC-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list=new ArrayList<>();

            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());

            arr=new int[N+1];
            for(int i=0;i<M+W;i++){
                st=new StringTokenizer(br.readLine());
                int S=Integer.parseInt(st.nextToken());
                int E=Integer.parseInt(st.nextToken());
                int T=Integer.parseInt(st.nextToken());

                if(i<M){
                    list.add(new TimeTravel(S,E,T));
                    list.add(new TimeTravel(E,S,T));
                }else{
                    list.add(new TimeTravel(S,E,-T));

                }

            }

            findMin();
            System.out.println(answer==false?"NO":"YES");
            answer=false;
        }


        br.close();
    }

    private static void findMin() {
        Arrays.fill(arr,987654321);
        arr[1]=0;
        for(int i=0;i<N;i++){
            for(int k=0;k<list.size();k++){
                TimeTravel timeTravel = list.get(k);
                if(arr[timeTravel.E]>arr[timeTravel.S]+ timeTravel.T){
                    arr[timeTravel.E]=arr[timeTravel.S]+ timeTravel.T;
                }
            }
        }

        for(int k=0;k<list.size();k++){
            TimeTravel timeTravel=list.get(k);
            if(arr[timeTravel.E]>arr[timeTravel.S]+ timeTravel.T){
                answer=true;
                break;
            }
        }
    }
}

class TimeTravel{
    int S,E,T;

    public TimeTravel(int s, int e, int t) {
        S = s;
        E = e;
        T = t;
    }

    @Override
    public String toString() {
        return "TimeTravel{" +
                "S=" + S +
                ", E=" + E +
                ", T=" + T +
                '}';
    }
}
