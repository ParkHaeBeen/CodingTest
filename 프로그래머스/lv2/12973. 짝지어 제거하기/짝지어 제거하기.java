import java.util.*;
class Solution{
    public int solution(String s){
        int pos = 0;
        Stack<String> strStack = new Stack<>();

        while(pos < s.length()) {

            if(strStack.isEmpty() || !strStack.peek().equals(s.substring(pos, pos+1))) {
                strStack.push(s.substring(pos, pos+1));
            } else if(strStack.peek().equals(s.substring(pos, pos+1))) {
                strStack.pop();
            }

            pos++;
        }
        if(strStack.size() != 0) {
            return 0;
        }

        return 1;
    }
}