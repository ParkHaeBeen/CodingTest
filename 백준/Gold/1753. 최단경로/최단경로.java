
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V,E,K;
    static ArrayList<ArrayList<Edge>> list =new ArrayList<>();
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        K=Integer.parseInt(br.readLine());
        arr=new int[V+1];
        check=new boolean[V+1];
        Arrays.fill(arr,Integer.MAX_VALUE);

        for(int i=0;i<=V;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            list.get(u).add(new Edge(v,w));
        }



        arr[K]=0;
        solution(K);

        for(int i=1;i<=V;i++){
            if(arr[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(arr[i]);
            }
        }
    }

    private static void solution(int idx) {
        PriorityQueue<Edge> edge=new PriorityQueue<>();
        edge.add(new Edge(idx,0));


        while(!edge.isEmpty()){
            Edge poll1 = edge.poll();
            int now=poll1.v;
            int cost=poll1.w;
            if(check[now]){
                continue;
            }
            check[now]=true;

            for(int i=0;i<list.get(now).size();i++) {
                Edge edges = list.get(now).get(i);
                if (check[edges.v] == false) {
                    int nextcost = edges.w + cost;
                    if (arr[edges.v] > nextcost) {
                        arr[edges.v] = nextcost;
                        edge.add(new Edge(edges.v, nextcost));
                    }
                }

            }
        }

    }
}

class Edge implements Comparable<Edge>{
    int v,w;

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w-o.w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}
