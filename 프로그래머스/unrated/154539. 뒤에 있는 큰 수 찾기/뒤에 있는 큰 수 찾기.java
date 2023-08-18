import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int idx=numbers.length-2;
        answer[numbers.length-1]=-1;
        ArrayDeque<Integer> list=new ArrayDeque<>();
        int max=numbers[numbers.length-1];
        while(idx>=0){
            if(numbers[idx]<max){
                answer[idx]=max;
                if(idx>=1&&numbers[idx]>numbers[idx-1]){
                    list.add(max);
                    max=numbers[idx];
                }
            }else {
                int idx2=list.size()-1;
                if(list.size()!=0) {
                    while (idx2>=0) {
                        Integer integer = list.getLast();
                        if (integer > numbers[idx]) {
                            answer[idx] = integer;
                            break;
                        }
                        list.pollLast();
                        
                        idx2--;
                    }
                }
                if(answer[idx]==0) {
                    answer[idx] = -1;
                }
                max=numbers[idx];
            }
            idx--;
        }

        return answer;
    }
}