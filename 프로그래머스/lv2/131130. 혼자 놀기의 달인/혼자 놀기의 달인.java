import java.util.*;
class Solution {
    static boolean[] visitied;
    static List<Integer> counts=new ArrayList<>();

    public int solution(int[] cards) {
        int answer = 0;
        visitied=new boolean[cards.length];
        for(int i=0;i<cards.length;i++){
            if(visitied[i]==false) {
                getScore(i, cards, 0);
            }
        }
        if(counts.size()==1){
            return 0;
        }
        Collections.sort(counts,Collections.reverseOrder());
        answer=counts.get(0)*counts.get(1);
        return answer;
    }

    private void getScore(int idx,int[]cards,int count) {
        if(visitied[idx]){
            System.out.println(count);
           counts.add(count);
           return;
        }
        if(visitied[idx]==false){
            visitied[idx]=true;
            getScore(cards[idx]-1,cards,count+1);
        }
    }
    
}