import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,t;
    static int s,g,h;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge2>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        ArrayList<String> result=new ArrayList<>();
        while(T-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());

            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            t=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            g=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            list=new ArrayList<>();
            for(int i=0;i<=n;i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                int start=Integer.parseInt(st.nextToken());
                int end=Integer.parseInt(st.nextToken());
                int price=Integer.parseInt(st.nextToken());

                list.get(start).add(new Edge2(end,price));
                list.get(end).add(new Edge2(start,price));
            }

            int minToGH = findMin(s, g);
            minToGH+=findMin(g, h);
            int mintToHG = findMin(s, h) + findMin(h, g);
            LinkedList<Integer> list=new LinkedList<>();
            for(int i=0;i<t;i++) {
                int t1=Integer.parseInt(br.readLine());
                int minT1 = findMin(s, t1);
                int minToHT1=findMin(h,t1);
                int minToGT1=findMin(g,t1);

                int result1=minToGH+minToHT1;
                int result2=mintToHG+minToGT1;

                if(result1==minT1||result2==minT1){
                    list.add(t1);
                }

            }
            Collections.sort(list);
            StringBuilder sb=new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer+" ");
            }

            result.add(sb.toString().trim());
        }
        for (String s1 : result) {
            System.out.println( s1);
        }
    }

    private static int findMin(int start, int end) {
        PriorityQueue<Edge2> pq=new PriorityQueue<>();
        pq.add(new Edge2(start,0));
        visited=new boolean[n+1];
        int answer=0;
        while(!pq.isEmpty()){
            Edge2 now = pq.poll();
            int nowStart=now.start;
            int nowPrice=now.price;
            if(nowStart==end){
                answer=nowPrice;
                break;
            }
            if(visited[nowStart]) continue;

            visited[nowStart]=true;
            for(int i=0;i<list.get(nowStart).size();i++){
                Edge2 next = list.get(nowStart).get(i);
                if(visited[next.start]==false){
                    pq.add(new Edge2(next.start,next.price+nowPrice));
                }
            }

        }
        return answer;
    }
}

class Edge2 implements Comparable<Edge2>{
    int start,price;

    public Edge2(int start, int price) {
        this.start = start;
        this.price = price;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.price-o.price;
    }
}