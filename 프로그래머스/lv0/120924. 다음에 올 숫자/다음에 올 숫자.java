class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int first=common[0];
        int gap=common[1]-common[0];
        if(gap==(common[2]-common[1])){
            answer=first+gap*(common.length);
        }else{
            gap=common[1]/common[0];
            answer= (int) (first*((long)Math.pow(gap,common.length)));
        }
        return answer;
    }
}