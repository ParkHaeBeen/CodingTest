import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static int answer=Integer.MIN_VALUE;
    public int solution(int n, int k, int[] enemy) {
        if(k>=enemy.length){
            return enemy.length;
        }
        getMaxRound(n,k,enemy,0,enemy.length);
        return answer;
    }
    public void getMaxRound(int n,int k, int[] enemy,int start,int end){
       
        
        while(start<end){
             int mid=(start+end)/2;
            if(possibleDefence(mid,enemy,k,n)){
                start=mid+1;
            }else{
               end=mid;
            }
        }
        answer=start;
        
    }
    
    public boolean possibleDefence(int mid,int [] enemy,int k,int n){
         List<Integer> collect = Arrays.stream(enemy, 0, mid + 1)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int nn = n;

        int size = collect.size();

        for (int i = 0; i < size; i++) {
            Integer el = collect.get(i);
            if (el <= nn) {
                nn -= el;
                continue;
            }
         
            return k >= size - i; 
        }
        return true;
        
    }
}