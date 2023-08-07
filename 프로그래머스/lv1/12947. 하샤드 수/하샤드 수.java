class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num= String.valueOf(x);
        char[] nums=num.toCharArray();
        int sum=0;
        for(char n:nums){
            sum+=n-'0';
        }
        
        if(x%sum!=0){
            answer=false;
        }
        return answer;
    }
}