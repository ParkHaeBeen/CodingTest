

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    final static int MAX=1000000+10;
    static boolean[] visited;
    static boolean[] visited2;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> queue;

    static int N,M,V;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());

        graph=new ArrayList[MAX];
        visited=new boolean[MAX];
        visited2=new boolean[MAX];

        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList();
        }

        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(graph[i]);
        }

        dfs(V);
        System.out.println();
        bfs(V);


    }

    private static void bfs(int v) {
        visited2[v]=true;
        queue=new ArrayList<>();

        queue.add(v);
        while(!queue.isEmpty()){
            Integer remove = queue.remove(0);
            System.out.print(remove+" ");
            for(int i=0;i< graph[remove].size();i++){
                Integer next = graph[remove].get(i);
                if(visited2[next]==false) {
                    queue.add(next);
                    visited2[next] = true;
                }
            }
        }

    }

    private static void dfs(int v) {
        visited[v]=true;
        System.out.print(v+" ");

        for(int i=0;i<graph[v].size();i++){
            Integer next = graph[v].get(i);
            if(visited[next]==false){
                dfs(next);
            }
        }

    }
}
