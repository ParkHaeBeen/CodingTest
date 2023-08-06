import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count=0;
        Arrays.sort(d);
        for(int money:d){
            answer+=money;
            if(answer>budget){
                break;
            }
            count++;
        }
        return count;
    }
}