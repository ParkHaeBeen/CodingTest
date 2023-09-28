import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);

            for(int i=0;i<phone_book.length;i++){
                if(i==0) continue;
                if(phone_book[i].startsWith(phone_book[i-1])) return false;
            }
            return answer;
    }
}