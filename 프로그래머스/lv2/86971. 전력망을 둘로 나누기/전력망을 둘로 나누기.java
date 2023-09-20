import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> list =new ArrayList<>();
    static int count;
    static int answer=Integer.MAX_VALUE;
    public static int solution(int n, int[][] wires) {
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] w:wires){
            list.get(w[0]).add(w[1]);
            list.get(w[1]).add(w[0]);
        }


        for(int[] w:wires){
            boolean[] visited=new boolean[n+1];
            visited[w[0]]=true;
            count=1;
            visited[w[1]]=true;
            getCount(w[1],visited,0,0);
            int one=n-count;
            answer=Math.min(answer,Math.abs(one-count));

        }
        return answer;
    }

    public static void getCount(int start,boolean[] visited,int cnt,int L){
        for(int i=0;i<list.get(start).size();i++){
            int num=list.get(start).get(i);
            if(!visited[num]){
                visited[num]=true;
                count++;
                getCount(num,visited,cnt++,L+1);
            }
        }
    }
}