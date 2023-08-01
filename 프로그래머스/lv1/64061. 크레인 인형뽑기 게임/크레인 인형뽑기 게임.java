import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> list=new Stack<>();
        for(int move:moves){
            int index=0;
            while(true){

                System.out.print(" "+board[index][move-1]);
                if(board[index][move-1]!=0){
                    if(list.size()>0&&list.peek()==board[index][move-1]){
                        list.pop();
                        board[index][move-1]=0;
                        answer++;
                        break;
                    }else{
                        list.add(board[index][move-1]);
                        board[index][move-1]=0;
                        break;
                    }
                }

                if(index==board.length-1){
                    break;
                }
                index++;

            }
        }

        answer=answer*2;
        return answer;
    }
}