import java.io.*;
import java.util.*;

public class Main{
    static int max1=Integer.MIN_VALUE;
    static int vertex=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        List<List<Node2>> nodes=new LinkedList<>();
        for(int i=0;i<=n;i++){
            nodes.add(new LinkedList<>());
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            nodes.get(parent).add(new Node2(child,value));
            nodes.get(child).add(new Node2(parent,value));

        }
        boolean[] visited=new boolean[n+1];
        visited[1]=true;
         getDFS(nodes, 1, visited, 0);

        visited=new boolean[n+1];
        visited[vertex]=true;
        getDFS(nodes,vertex,visited,0);
        System.out.println(max1);
        br.close();

    }

    private static void getDFS(List<List<Node2>> nodes, int leaf, boolean[] vistied,int sum) {

        for(int i=0;i<nodes.get(leaf).size();i++){
            Node2 next = nodes.get(leaf).get(i);
            if(vistied[next.vertex]) continue;

            vistied[next.vertex]=true;
            getDFS(nodes,next.vertex,vistied,sum+next.weight);
            vistied[next.vertex]=false;
        }

        if(max1<sum){
            max1=sum;
            vertex=leaf;
        }

    }
}
class Node2 {
    int vertex, weight;

    public Node2(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
