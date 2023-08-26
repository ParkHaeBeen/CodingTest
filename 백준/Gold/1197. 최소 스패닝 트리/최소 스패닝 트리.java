import java.io.*;
import java.util.*;
public class Main {

    static int V,E;
    static PriorityQueue<Edge3> pq=new PriorityQueue<>();
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            pq.add(new Edge3(start,end,cost));
        }
        group=new int[V+1];
        for(int i=1;i<=V;i++){
            group[i]=i;
        }

        int answer=0;
       while(!pq.isEmpty()) {
            Edge3 edge3 = pq.poll();
           int f1=find(edge3.v1);
            int f2=find(edge3.v2);

            if(f1!=f2){
                answer+=edge3.cost;
                group[f2]=f1;
            }
        }

        System.out.println(answer);
        br.close();

    }

    private static int find(int v1) {
        if(v1==group[v1]){
            return v1;
        }else{
          return group[v1]=find(group[v1]);
        }
    }
}
class Edge3 implements Comparable<Edge3>{
    public int v1;
    public int v2;
    public int cost;
    Edge3(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge3 ob){
        return (this.cost-ob.cost);
    }
}