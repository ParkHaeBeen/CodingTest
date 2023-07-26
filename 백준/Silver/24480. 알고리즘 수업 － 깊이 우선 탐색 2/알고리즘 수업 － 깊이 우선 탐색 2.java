
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    final static int MAX=1000000+10;

    static ArrayList<Integer>[] graph2;
    static boolean [] visited;
    static int [] answer;
    static int N,M,R;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        graph2= new ArrayList[MAX];

        for(int i=1;i<=N;i++){
            graph2[i]=new ArrayList<>();
        }

        visited=new boolean[MAX];
        answer=new int[MAX];
        order=1; //현재 dfs를 방ㄴ문하는 순서

        //1.그래프에 정보채우기
        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph2[x].add(y);
            graph2[y].add(x);
        }

        // 2.오름차순 정렬
        for(int i=1;i<=N;i++){
            Collections.sort(graph2[i],Collections.reverseOrder());
        }

        //3.dfs호출
        dfs(R);


        //4.츌력
        for(int k=1;k<=N;k++){
            bw.write(String.valueOf(answer[k]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int r) {
        answer[r]=order;
        visited[r]=true;
        order++;
        for(int i=0;i<graph2[r].size();i++){
            int next=graph2[r].get(i);
            if(visited[next]==false){
                dfs(next);
            }
        }


    }
}
