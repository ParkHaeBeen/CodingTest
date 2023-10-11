import java.util.*;
import java.io.*;
public class Main{
    static long answer=Long.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int V=Integer.parseInt(br.readLine());

        List<List<Node>> trees=new ArrayList<>();
        for(int i=0;i<=V;i++){
            trees.add(new ArrayList());
        }
        for(int i=0;i<V;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            List rela = trees.get(start);
            while(true){
                int num1=Integer.parseInt(st.nextToken());

                if(num1==-1)break;

                int dis=Integer.parseInt(st.nextToken());
                rela.add(new Node(num1,dis));

            }
        }


        int startNod=getBfs(1,trees,V)[0];
        answer=getBfs(startNod,trees,V)[1];


        System.out.println(answer);
    }

    private static int[] getBfs(int start, List<List<Node>> trees,int V) {
        boolean[] visited=new boolean[V+1];

        ArrayDeque<int[]> ad=new ArrayDeque<>();
        ad.add(new int[]{start,0});
        int maxDistance = 0;
        int maxNode = start;
        while(!ad.isEmpty()){
            int size=ad.size();
            for(int i=0;i<size;i++){
                int[] now = ad.poll();


                visited[now[0]]=true;
                if(now[1] > maxDistance) {
                    maxDistance = now[1];
                    maxNode = now[0];
                }

                List<Node> nextNodes = trees.get(now[0]);
                for (Node nextNode : nextNodes) {
                    if(visited[nextNode.end]) continue;
                    ad.add(new int[]{nextNode.end,nextNode.distance+now[1]});
                    answer=Math.max(answer,nextNode.distance+now[1]);
                }

            }


        }
        return new int[]{maxNode,maxDistance};
    }
}
class Node{
    int end,distance;

    public Node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }
}