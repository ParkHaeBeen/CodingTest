import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> list = new LinkedList<>();
        int index=0;
        for(int dayScore:score){
            list.add(dayScore);
            Collections.sort(list,Collections.reverseOrder());
            if(list.size()<k){
                answer[index++]=list.getLast();
            }else{
                answer[index++]=list.get(k-1);
            }

        }
        return answer;
    }
}