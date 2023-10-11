class Solution
{
    public int solution(int [][]board){
        int answer = 0;
        int length=0;
        if(board.length==1){
            for(int i=0;i<board[0].length;i++){
                if(board[0][i]==1){
                    return 1;
                }
            }            
            return 0;
        }
        
        int[][] dp=new int[board.length][board[0].length];
        dp[0]=board[0].clone();
        for(int i=1;i<board.length;i++){
            for(int k=0;k<board[0].length;k++){
               if(board[i][k]==0) continue;
                
                if(k==0){ 
                    dp[i][k]=1;
                    continue;
                }
                
                if(board[i][k] == 1){
                    dp[i][k] = Math.min(dp[i-1][k-1], Math.min(dp[i-1][k], dp[i][k-1])) + 1;
                }else{
                    dp[i][k]=1;
                }
                
                answer=Math.max(answer,dp[i][k]*dp[i][k]);
            }
        }

        
        return answer;
    }
    
}