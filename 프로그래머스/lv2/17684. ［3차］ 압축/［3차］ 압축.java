import java.util.*;
class Solution {
 public int[] solution(String msg) {

        List<Integer> list=new ArrayList<>();
        Map<String,Integer> maps=new TreeMap<>();
        int startNum=27;
        for(int i=0;i<msg.length();i++){
            int start=msg.charAt(i)-64;
            int startidx=i+1;
            String st=""+msg.charAt(i);
            while(startidx<msg.length()){
                st+=msg.charAt(startidx);
                if(!maps.containsKey(st)){
                    maps.put(st,startNum++);
                    break;
                }
                startidx++;
                if(startidx==msg.length())break;
            }
            if(startidx-i==1){
                list.add(start);
            }else{
                String s=msg.substring(i,startidx);
                int numidx=maps.get(s);
                list.add(numidx);
                i=startidx-1;
            }
        }
        int[] answer = new int[list.size()];
        int index=0;
        for(int dd:list){
            answer[index++]=dd;
        }
        return answer;
    }
}