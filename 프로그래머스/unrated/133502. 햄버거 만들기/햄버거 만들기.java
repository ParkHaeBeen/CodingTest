import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> list= new Stack<>();
        for(int gre:ingredient){
            list.add(gre);
            
            if(list.size()>=4){
                if(list.get(list.size()-1)==1&&list.get(list.size()-2)==3&&list.get(list.size()-3)==2&&
                  list.get(list.size()-4)==1){
                    for(int i=0;i<4;i++){
                        list.pop();
                        
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}