import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String news=s.substring(2,s.length()-2);
        String[] split=news.split("},\\{");
        Arrays.sort(split, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });
 
        List<Integer> nums=new LinkedList<>();
        for(String ss:split){
            String[] num=ss.split(",");
            for(int i=0;i<num.length;i++){
                int number=Integer.parseInt(num[i]);
                if(!nums.contains(number)){
                    nums.add(number);
                }
            }
        }
        
        answer=new int[nums.size()];
        int idx=0;
        for(int num:nums){
           answer[idx++]=num;
        }
    
        return answer;
    }
}