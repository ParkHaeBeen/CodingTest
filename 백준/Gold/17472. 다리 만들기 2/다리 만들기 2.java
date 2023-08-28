import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static int[][] map;
    static int[] group;
    static int N,M;
    static LinkedList<Island> list=new LinkedList<>();
    static ArrayList<ArrayList<Node2>> island=new ArrayList<>();
    static int[][]dir=new int[][]{
            {0,0},{0,1},{0,-1},{1,0},{-1,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                int num=Integer.parseInt(st.nextToken());
                map[i][k]=num;
            }
        }

        for(int i=0;i<=6;i++){
            island.add(new ArrayList<>());
        }
        int num=1;
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(map[i][k]==1) {
                    dfs(i, k,num);
                    num++;
                }
            }
        }

        for(int i=1;i<num;i++){
            for(int k=i+1;k<num;k++){
                ArrayList<Node2> island1 = island.get(i);
                ArrayList<Node2> island2 = island.get(k);
                findBridge(island1,island2,i,k);
            }
        }

        group=new int[num+1];
        for(int i=0;i<=num;i++){
            group[i]=i;
        }
        Collections.sort(list);
        int answer=0;
        for (Island island1 : list) {
            int group1=findgroup(island1.land1);
            int group2=findgroup(island1.land2);

            if(group1!=group2){
                answer+=island1.cost;
                group[group2]=group1;
            }
        }

        int root = findgroup(1);
        for (int i = 2; i < num; i++) {
            if (findgroup(i) != root) {
                answer=0;
                break;
            }
        }

        if(answer==0){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
        br.close();
    }

    private static int findgroup(int land2) {
        if(group[land2]==land2){
            return land2;
        }else{
            return group[land2]=findgroup(group[land2]);
        }
    }

    private static void findBridge(ArrayList<Node2> island1, ArrayList<Node2> island2,int group1,int group2) {
        for (Node2 start : island1) {
            for (Node2 end : island2) {
                if (start.y == end.y) {
                    if (start.x < end.x) {
                        if (checkBridge(start.y, start.x, end.x, 1)) {
                            int len = end.x - start.x - 1;
                            if (len >= 2) list.add(new Island(group1, group2, len));
                        }
                    } else {
                        if (checkBridge(start.y, end.x, start.x, 1)) {
                            int len = start.x - end.x - 1;
                            if (len >= 2)list.add(new Island(group1, group2, len));
                        }
                    }
                } else if (start.x == end.x) {
                    if (start.y < end.y) {
                        if (checkBridge(start.x, start.y, end.y, 0)) {
                            int len = end.y - start.y - 1;
                            if (len >= 2) list.add(new Island(group1, group2, len));
                        }
                    } else {
                        if (checkBridge(start.x, end.y, start.y, 0)) {
                            int len = start.y - end.y - 1;
                            if (len >= 2) list.add(new Island(group1, group2, len));
                        }
                    }
                }
            }
        }
    }

    private static boolean checkBridge(int fixed, int start, int end, int dir) {
        for (int i = start + 1; i < end; i++) {
            if (dir == 1) { // 가로 다리
                if (map[fixed][i] != 0) return false;
            } else { // 세로 다리
                if (map[i][fixed] != 0) return false;
            }
        }
        return true;
    }

    private static void dfs(int y,int x,int islandNum) {


        for (int[] direction : dir) {
            int newY=y+direction[0];
            int newX=x+direction[1];

            if(newY>=N||newY<0||newX>=M||newX<0){
                continue;
            }
            if(map[newY][newX]==1){
                map[newY][newX]=2;
                island.get(islandNum).add(new Node2(newY,newX));
                dfs(newY,newX,islandNum);
            }
        }
    }
}

class Island implements Comparable<Island>{
    int land1, land2,cost;

    public Island(int land1, int land2, int cost) {
        this.land1 = land1;
        this.land2 = land2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Island o) {
        return this.cost-o.cost;
    }

}

class Node2{
    int y,x;

    public Node2(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
