import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<=number;i++){
            int count=1;
            for(int k=1;k<=i/2;k++){
                if(i%k==0){
                    count++;
                }
                
                if(count>limit){
                    count=power;
                    break;
                }
            }

            
            
            list.add(count);
            
        }

        answer=list.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}