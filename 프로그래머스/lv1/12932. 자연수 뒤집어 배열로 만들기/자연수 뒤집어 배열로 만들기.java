class Solution {
    public int[] solution(long n) {
        
        String num=String.valueOf(n);
        int[] answer = new int[num.length()];
        String[] nums=num.split("");
        int idx=0;
        for(int i=nums.length-1;i>=0;i--){
            answer[idx++]=Integer.parseInt(nums[i]);
        }
        return answer;
    }
}