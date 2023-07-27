import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);

        int box=score.length/m;
        int index=score.length-1-m+1;
        for(int i=0;i<box;i++){

            answer+=score[index]*m;
            index=index-m;
        }
        
        return answer;
    }
}