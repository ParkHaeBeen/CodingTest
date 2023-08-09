import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num=String.valueOf(n);
        char[] nums=num.toCharArray();
        for(char c:nums){
            answer+=c-'0';
        }
        return answer;
    }
}