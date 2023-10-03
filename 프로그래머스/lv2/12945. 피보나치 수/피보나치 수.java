import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        answer=getPibo(dp,n)%1234567;
        return answer;
    }
    
    public int getPibo(int[] dp,int n){
        if(dp[n]!=-1){
            return dp[n];
        }
        
        return dp[n]=getPibo(dp,n-1)%1234567+getPibo(dp,n-2)%1234567;
    }
}