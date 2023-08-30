import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sideContainer=new Stack<>();
        LinkedList<Integer> mainContainer=new LinkedList<>();
        for(int i=0;i<order.length;i++){
            if(i==0){
                for(int k=1;k<order[i];k++){
                    sideContainer.add(k);
                }
                for(int k=order[i]+1;k<=order.length;k++){
                    mainContainer.add(k);
                }
                answer++;
            }else{               
                if(!sideContainer.isEmpty()&&sideContainer.peek()==order[i]){
                    sideContainer.pop();
                }else if(!mainContainer.isEmpty()&&mainContainer.contains(order[i])){
                    int idx = mainContainer.indexOf(order[i]);
                    for(int k=0;k<idx;k++) {
                        sideContainer.add(mainContainer.pollFirst());
                    }
                    mainContainer.pollFirst();
                }else{
                    break;
                }
                answer++;
            }
            
        }
        return answer;
    }
}