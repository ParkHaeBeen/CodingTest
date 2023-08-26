import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<SpaceShip> list=new ArrayList<>();
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            list.add(new SpaceShip(start,end));
        }

        group=new int[N];
        for(int i=0;i<N;i++){
            group[i]=i;
        }
        double answer=0;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken())-1;
            int end=Integer.parseInt(st.nextToken())-1;

            union(start,end);
        }

        PriorityQueue<Edge4> pq=new PriorityQueue<>();
        for(int i=0;i<list.size()-1;i++){
            for(int k=i+1;k<list.size();k++){
                pq.add(new Edge4(i,k,list.get(i).getDis(list.get(k))));
            }
        }
        while(!pq.isEmpty()){
            Edge4 space = pq.poll();
            int group1=find(space.v1);
            int group2=find(space.v2);

            if(group1!=group2){
                answer+=space.weight;
                group[group2]=group1;
            }
        }

        System.out.println(String.format("%.2f",answer));
        br.close();
    }

    private static int find(int v1) {
        if(v1==group[v1]){
            return v1;
        }else{
           return group[v1]=find(group[v1]);
        }
    }
    private static void union(int start,int end){
        int group1=find(start);
        int group2=find(end);

        if(group1!=group2){
            group[group2]=group1;
        }
    }

}

class SpaceShip{
    int start,end;

    public SpaceShip(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public double getDis(SpaceShip sp){
        return Math.sqrt(Math.pow(this.start-sp.start,2)+Math.pow(this.end-sp.end,2));
    }
}

class Edge4 implements Comparable<Edge4> {
    int v1, v2;
    double weight;

    Edge4(int v1, int v2, double weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public int compareTo(Edge4 e) {
        return Double.compare(weight, e.weight);
    }
}