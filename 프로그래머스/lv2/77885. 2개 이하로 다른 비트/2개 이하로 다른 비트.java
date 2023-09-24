class Solution {
public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index=0;
        for (long num : numbers) {
            String nums = Long.toBinaryString(num);
            if(nums.indexOf("0")==-1){
                nums="10"+nums.substring(1,nums.length());
            }else if(nums.indexOf("1",1)==-1){
                nums=nums.substring(0,nums.length()-1)+"1";
            }else{
                int idx = nums.lastIndexOf("01");
                String num2=nums;
                if(idx!=-1){
                    nums=nums.substring(0,idx)+"10"+nums.substring(idx+2);
                }
                
                idx=nums.lastIndexOf("0");
                num2=num2.substring(0,idx)+"1"+num2.substring(idx+1);
                long l2=Long.parseLong(num2,2);
                long l1=Long.parseLong(nums,2);
                if(l2>num&&l2<l1||num>=l1){
                    nums=num2;
                }
                
            }
            answer[index++]=Long.parseLong(nums,2);
        }
        return answer;
    }
}