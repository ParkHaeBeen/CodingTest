import java.util.*;

class Solution {
 public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list= new LinkedList<>();
        for (int priority : priorities) {
            list.add(priority);
        }

        int find=list.get(location);
        while(true){
            int max=find;
            for (Integer integer : list) {
                if(max<=integer){
                    max=integer;
                }
            }

            int indexed = list.indexOf(max);
            if(max!=list.peek()) {

                list.remove(location);
                list.add(location, 10);
                for (int i = 0; i < indexed; i++) {
                    list.add(list.poll());
                }
                location = list.indexOf(10);
                list.remove(location);
                list.add(location, find);

            }

            if (max == find) {
                List<Integer> list1 = list.subList(0, location);
                int min = 0;
                for (Integer integer : list1) {
                    if (integer < find) {
                        min++;
                    }
                }
                answer += location - min+1;
                if(answer==0){
                    answer=1;
                }
                break;
            }

            list.remove();
            location--;
            answer++;
        }

        return answer;
    }
}