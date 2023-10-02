import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                cnt++;
            }else{
                if(cnt==0){
                    return false;
                }
                
                cnt--;
            }
        }
        
        if(cnt!=0){
            return false;
        }
        return answer;
    }
}