import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        String[] split = before.split("");


        List<String> list = Arrays.asList(split);
        list.sort(String::compareTo);

        char[] charArray = after.toCharArray();
        Arrays.sort(charArray);

        int k=0;
        for (String s1 : list) {
            boolean equals = String.valueOf(charArray[k]).equals(s1);
            if(equals==false){
                answer= 0;
                break;
            }
            k++;
            
        }

        return answer;
    }
}