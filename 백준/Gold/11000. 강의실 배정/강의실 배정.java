import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Time> times=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            times.add(new Time(start,end));
        }

        PriorityQueue<Integer> endTime=new PriorityQueue<>();
        while(!times.isEmpty()){
            Time now = times.poll();

            if(endTime.isEmpty()){
                endTime.add(now.end);
            }else{
                if(endTime.peek()>now.start){
                    endTime.add(now.end);
                }else if(endTime.peek()<=now.start){
                    endTime.poll();
                    endTime.add(now.end);
                }
            }
        }
        
        System.out.println(endTime.size());
        br.close();
    }
}
class Time implements Comparable<Time>{
    int start,end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(o.start==this.start){
            return this.end-o.end;
        }
        return this.start-o.start;
    }
}