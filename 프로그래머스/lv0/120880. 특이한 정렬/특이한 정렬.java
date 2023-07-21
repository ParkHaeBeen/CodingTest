import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
         int[] answer = new int[numlist.length];
        LinkedList<Integer> list= new LinkedList<>();
        TreeMap<Integer,String> map=new TreeMap<>();
        for (int i : numlist) {
            boolean check = map.containsKey(Math.abs(i - n));
            if(check==true){
                map.put(Math.abs(i-n),"Y");   
            }else {
                if (i - n >= 0) {
                    map.put(Math.abs(i - n), "P");
                } else {
                    map.put(Math.abs(i - n), "M");
                }
            }
        }
        int index=0;
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            Integer param=integerStringEntry.getKey();
            String param2=integerStringEntry.getValue();
            if(param2.equals("P")){
                answer[index]=n+param;
            } else if (param2.equals("Y")) {
                answer[index++]=n+param;
                answer[index]=n-param;
            }else {
                answer[index]=n-param;
            }
            index++;
        }

      
        return answer;
    }
}