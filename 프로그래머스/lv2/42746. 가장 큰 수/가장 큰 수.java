import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums=new Integer[numbers.length];
        boolean zeroflag=true;
        for(int i=0;i<nums.length;i++){
            nums[i]=numbers[i];
            if(nums[i]!=0) zeroflag=false;
        }
        if(zeroflag){
            return "0";
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Long.parseLong(o1+""+o2)>Long.parseLong(o2+""+o1)){
                
                    return -1;
                }else if((o1+""+o2).equals((o2+""+o1))){
                    return (o1+"").length()-(o2+"").length();
                }
                return 1;
            }
        });
        
        for(int num:nums){
            answer+=num;
        }
        return answer;
    }
}