class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] clone = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            clone[i]=board[i].clone();
        }
        for(int i=0;i<board.length;i++){
            for(int k=0;k<board[0].length;k++){
                    System.out.println(board[i][k]);
                if(board[i][k]==1){
                    System.out.println(i+" "+k);
                    for(int h=i;h<i+3;h++){
                        clone[Math.max(h-1>board.length-1?board.length-1:h-1,0)][Math.min(k-1<0?0:k-1,board[0].length-1)]=3;
                        clone[Math.max(h-1>board.length-1?board.length-1:h-1,0)][Math.min(k,board[0].length-1)]=3;
                        clone[Math.max(h-1>board.length-1?board.length-1:h-1,0)][Math.min(k+1,board[0].length-1)]=3;
                    }
                }
            }
        }

        for (int[] ints : clone) {
            for (int anInt : ints) {
                if(anInt==3){
                    answer++;
                }
            }
        }
        answer=board.length*board[0].length-answer;
        return answer;
    }
}