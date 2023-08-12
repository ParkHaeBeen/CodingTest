import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static ArrayList<ArrayList<Node>> list =new ArrayList<>();
    static long[] arr;
    static boolean answer=false;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new long[N+1];

        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end,cost));
        }

        arr[1]=0;

        solution();

        if(answer){
            System.out.println(-1);
        }else {
            for (int i=2;i<=N;i++) {
                if(arr[i]==Integer.MAX_VALUE){
                    System.out.println(-1);
                }else{
                    System.out.println(arr[i]);
                }
            }
        }

    }

    private static void solution() {
        // N-1번만큼 각 노드에 대한 relaxation을 수행
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j <= N; j++) { // 정점은 1부터 N까지이므로
                for (Node edge : list.get(j)) {
                    if (arr[j] != Integer.MAX_VALUE && arr[edge.end] > arr[j] + edge.cost) {
                        arr[edge.end] = arr[j] + edge.cost;
                    }
                }
            }
        }

        // 음수 사이클 검사
        for (int j = 1; j <= N; j++) {
            for (Node edge : list.get(j)) {
                if (arr[j] != Integer.MAX_VALUE && arr[edge.end] > arr[j] + edge.cost) {
                    answer=true;
                    return;
                }
            }
        }
    }

}

class Node implements Comparable<Node>{
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
