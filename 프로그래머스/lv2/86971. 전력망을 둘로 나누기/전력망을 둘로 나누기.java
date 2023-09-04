import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static int solution(int n, int[][] wires) {
        int answer = -1;
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int min = Integer.MAX_VALUE;
        int mid=n/2;
        for(int i=0;i<wires.length;i++){
            boolean[] visited=new boolean[n+1];
            int v1=wires[i][0];
            int v2=wires[i][1];
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));

            int group = getGroup(1, visited);

            int diff=Math.abs(group-(n-group));

            min=Math.min(min,diff);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        return min;
    }

    private static int getGroup(int idx, boolean[] visited) {
        ArrayDeque<Integer> list2 = new ArrayDeque<>();
        list2.add(idx);
        int count=0;
        visited[idx]=true;
        while (true) {
            int length = list2.size();
            for (int i = 0; i < length; i++) {
                Integer num = list2.pollFirst();
                ArrayList<Integer> arrayList = list.get(num);
                for (Integer integer : arrayList) {
                    if (!visited[integer]) {
                        visited[integer]=true;
                        list2.add(integer);
                    }
                }
                count++;
            }
            if (length==0){
                break;
            }
        }
        return count;
    }
}