import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        int[] toplist2=new int[10001];
        Set<Integer> toplist=new HashSet<>();
        int detop=0;
        for(int top:topping){
            toplist2[top]++;
            toplist.add(top);          
            ad.add(top);
        }
        detop=toplist.size();

        LinkedList<Integer> tops2=new LinkedList<>();
        while(!ad.isEmpty()){
            Integer topp = ad.pop();
            if(toplist2[topp]==1){
                detop--;
            }
            toplist2[topp]--;


            if(!tops2.contains(topp)){
                tops2.add(topp);
            }

            if(detop<tops2.size()){
                break;
            }
            if(detop==tops2.size()){
                answer++;
            }
        }

      
        return answer;
    }
}