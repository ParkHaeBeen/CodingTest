import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String arr=s;
        int zerocnt=0;
        int change=0;
        while(!arr.equals("1")){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<arr.length();i++){
                char num=arr.charAt(i);
                if(num=='0'){
                    zerocnt++;
                }else{
                    sb.append("1");
                }
            }
            arr=Integer.toBinaryString(sb.toString().length());
            change++;
        }
        answer[0]=change;
        answer[1]=zerocnt;
        return answer;
    }
}