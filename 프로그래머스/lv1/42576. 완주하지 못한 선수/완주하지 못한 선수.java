import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> list=new HashMap<>();
        for(String par:participant){
            if(list.containsKey(par)){
                list.put(par,list.get(par)+1);
            }else{
                list.put(par,1);
            }
        }
        
        for(String com:completion){
            list.put(com,list.get(com)-1);
        }
        
        for (Map.Entry<String, Integer> stringIntegerEntry : list.entrySet()) {
            if(stringIntegerEntry.getValue()==1){
                answer=stringIntegerEntry.getKey();
                break;
            }
        }
        
        return answer;
    }
}