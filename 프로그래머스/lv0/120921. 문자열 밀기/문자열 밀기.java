import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Collectors;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        if(A.equals(B)){
            answer=0;
        }else{
        String[] split = A.split("");
        ArrayList<String> list= new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }

        String pro="";
        while(answer!=B.length()){
            list.add(0,list.remove(A.length()-1));
            answer++;
            String collect = list.stream().map(String::valueOf).collect(Collectors.joining());
            if(collect.equals(B)){
                break;
            }
        }

        if(answer==B.length()){
            answer=-1;
        }
        }
        return answer;
    }
}