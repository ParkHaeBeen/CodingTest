class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] grade=new int[]{6,6,5,4,3,2,1};
        int zero=0;
        int correct=0;
        for(int lotto:lottos){
            if(lotto==0){
                zero++;
            }else{
                for(int win:win_nums){
                    if(lotto==win){
                        correct++;
                    }
                }
            }
        }
        answer[0]=grade[correct+zero];
        answer[1]=grade[correct];
        return answer;
    }
}