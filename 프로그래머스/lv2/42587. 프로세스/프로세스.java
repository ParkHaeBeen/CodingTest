import java.util.*;
import java.util.List;
class Solution {
 public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list= new LinkedList<>();
        for (int priority : priorities) {
            list.add(priority);
        }
        //찾으려는 숫자
        int find=list.get(location);

        //찾으려는 숫자보다 큰 숫자 찾기

        while(true){
            int max=find;
            for (Integer integer : list) {
                if(max<=integer){
                    max=integer;
                }
            }
            //최댓값의 index찾기
            int indexed = list.indexOf(max);


            //맨앞에 max가 아닐때
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
                System.out.println("min = " + min);
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