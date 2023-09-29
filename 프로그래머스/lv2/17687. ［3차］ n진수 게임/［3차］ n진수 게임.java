import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        int stnum=0;
        while(sb.length()<=t*m){
            String num = Integer.toString(stnum,n);
            sb.append(num.toUpperCase());
            stnum++;
        }
        for(int i=0;i<t;i++){
            answer+=sb.substring(p-1,p);
            p+=m;
        }
        System.out.println(answer);
        return answer;
    }
}