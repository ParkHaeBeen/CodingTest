import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list;
        int index=0;
        for(int[] command:commands){
            list=new ArrayList<>();
            for(int i=command[0]-1;i<command[1];i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[index]=list.get(command[2]-1);
            index++;
        }
        return answer;
    }
}