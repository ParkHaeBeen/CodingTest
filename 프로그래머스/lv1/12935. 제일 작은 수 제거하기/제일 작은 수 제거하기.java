import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){
            return new int[]{-1};
        }
       LinkedList<Integer> list=new LinkedList<>();
        int min = Arrays.stream(arr).min().getAsInt();

        for (int i : arr) {
            if(i!=min&&!list.contains(i)){
                list.add(i);
            }
        }

        
        int[]answer=list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}