import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Star> list=new ArrayList<>();
    static int[] parent;
    static Map<Star,Star> list2=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            double star=Double.parseDouble(st.nextToken());
            double end=Double.parseDouble(st.nextToken());

            list.add(new Star(star,end));

        }

        PriorityQueue<Edge4> pq=new PriorityQueue<>();

        for(int i=0;i<list.size()-1;i++){
            for(int k=i+1;k<list.size();k++){
                pq.add(new Edge4(i,k,list.get(i).getDis(list.get(k))));
            }
        }

        double answer=0;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
            Edge4 now = pq.poll();
            int group1=find(now.v1);
            int grou2=find(now.v2);
            if(grou2!=group1) {
                parent[grou2]=group1;
                answer += now.weight;
            }
        }

        System.out.println(Math.round((answer*100))/100.0);
        br.close();
    }

    private static int find(int v1) {
        if(v1==parent[v1]) {
            return v1;
        }else{
            return parent[v1]=find(parent[v1]);
        }
    }
}

class Star{

    double x, y;

    Star( double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double getDis(Star st){
        return Math.sqrt(Math.pow(this.x-st.x,2)+Math.pow(this.y- st.y,2));
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