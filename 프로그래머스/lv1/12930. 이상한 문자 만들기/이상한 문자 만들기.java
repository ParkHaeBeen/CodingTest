import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb= new StringBuilder();
        String[] split = s.split("");
        int idx=0;
        for (String s1 : split) {
            if(!s1.equals(" ")){
                if(idx%2==0){
                    answer+=(s1.toUpperCase());
                }else{
                    answer+=(s1.toLowerCase());
                }
                idx++;
            }else{
                idx=0;
                System.out.println("dd"+s1);
                answer+=(s1);
            }
        }

        return answer;
    }
}