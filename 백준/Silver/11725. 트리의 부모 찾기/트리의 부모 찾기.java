
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    final static int MAX=100000+10;

    static ArrayList<Integer>[] graph2;
    static boolean [] visited;
    static int [] answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());

        //graph채우기
        graph2=new ArrayList[MAX];
        for(int i=1;i<=N;i++){
            graph2[i]=new ArrayList<>();
        }

        answer=new int[MAX];
        visited=new boolean[MAX];

        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            graph2[x].add(y);
            graph2[y].add(x);
        }


        dfs(1);

        for(int i=2;i<=N;i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();

    }

    private static void dfs(int idx) {
        visited[idx]=true;

        for(int i=0;i<graph2[idx].size();i++){
            int next=graph2[idx].get(i);
            if(visited[next]==false){
                answer[next]=idx;
                dfs(next);
            }
        }
    }
}
