import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
       int[] board = new int[1001];
        
        for(int weight : weights){
            if(board[weight]!=0){
                answer+=board[weight];           
            }
            if(weight*2<=1000&&board[weight*2]!=0){
                answer+=board[weight*2];  
            }
            if(weight%2==0&&weight/2>=100&&board[weight/2]!=0){
                answer+=board[weight/2];  
            }
            if(weight%2==0&&(weight/2)*3<=1000&&board[(weight/2)*3]!=0){
                answer+=board[(weight/2)*3];  
            }
            if(weight%3==0&&(weight/3)*2>=100&&board[(weight/3)*2]!=0){
                answer+=board[(weight/3)*2];  
            }
            if(weight%3==0&&(weight/3)*4<=1000&&board[(weight/3)*4]!=0){
                answer+=board[(weight/3)*4];  
            }        
            if(weight%4==0&&(weight/4)*3>=100&&board[(weight/4)*3]!=0){
                answer+=board[(weight/4)*3];  
            }
             
            board[weight]++;   
        }
        return answer;
    }
}