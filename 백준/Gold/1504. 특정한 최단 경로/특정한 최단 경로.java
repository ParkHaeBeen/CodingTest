import java.io.*;
import java.util.*;

public class Main {

    static int V,E,v1,v2;
    static ArrayList<ArrayList<Edge>> list =new ArrayList<>();
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        for(int i=0;i<=V;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            list.get(u).add(new Edge(v,w));
            list.get(v).add(new Edge(u,w));
        }

        if(E==0){
            System.out.println(-1);
        }else {

            st=new StringTokenizer(br.readLine());
            v1=Integer.parseInt(st.nextToken());
            v2=Integer.parseInt(st.nextToken());


            int onedis=solution(1,v1);
            int onedis2=solution(1,v2);
            int disv1 = solution(v1, v2);
            int disv2=solution(v2,v1);
            int dis2=solution(v1,V);
            int dis3=solution(v2,V);

            long result = onedis + disv1 + dis3;
            long result2 = onedis2 + disv2 + dis2;

            int answer= (result2>=200000000&&result>=200000000)?-1: (int) Math.min(result2, result);

            System.out.println( answer);
        }
        br.close();

    }


    private static int solution(int start, int v) {
        PriorityQueue<Edge> edge=new PriorityQueue<>();
        edge.add(new Edge(start,0));

        check=new boolean[V+1];
        arr=new int[V+1];
        Arrays.fill(arr, 200000000);
        while(!edge.isEmpty()){

            Edge poll1 = edge.poll();
            int now=poll1.v;
            int cost=poll1.w;

            if(now==v){
                return cost;
            }
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

        return  200000000;
    }

}
class Edge implements Comparable<Edge>{
    int v,w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w-o.w;
    }
    
}

