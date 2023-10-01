class Solution {
    public String solution(String s) {
        String answer = "";
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        String[] nums=s.split(" ");
        for(int i=0;i<nums.length;i++){
            int number=Integer.parseInt(nums[i]);
            max=Math.max(max,number);
            min=Math.min(min,number);
        }
        answer=min+" "+max;
        return answer;
    }
}