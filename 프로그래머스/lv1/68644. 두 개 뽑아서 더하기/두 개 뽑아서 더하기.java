import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
      
        TreeSet<Integer> list=new TreeSet<>();
        for (int i=0;i<numbers.length;i++) {
            for(int k=i+1;k<numbers.length;k++){
                list.add(numbers[i]+numbers[k]);
            }
        }
        
        int index=0;
        int []answer=new int[list.size()];
        for (Integer integer : list) {
            answer[index++]=integer;
        }
        return answer;
    }
}