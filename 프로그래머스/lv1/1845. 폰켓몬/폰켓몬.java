import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length=nums.length/2;
        HashSet<Integer> list=new HashSet<>();
        for(int num:nums){
            list.add(num);
        }
        if(list.size()>=length){
            
            answer=length;
        }else{
            answer=list.size();
        }
        return answer;
    }
}