import java.util.*;
class Solution {
    static StringBuilder sb=new StringBuilder();
    public String solution(String p) {
        String answer = "";
        if(p.equals("")){
            return answer;
        }
        
        answer= getCorrect(p);
        //System.out.println(sb.toString());
        return answer;
    }
    
    public String getCorrect(String p){
        if(p.equals("")){
            return "";
        }
        
        Stack<Character> left=new Stack<>();
        Stack<Character> right=new Stack<>();
        int idx=0;
       // System.out.println(p);
        while(true){
            if(left.size()!=0&&left.size()==right.size()){
                break;
            }
            
            char c=p.charAt(idx++);
            if(c=='('){
                left.add('(');
            }else{
                right.add(')');
            }
                        
        }
       
        String u=p.substring(0,idx);
        if(u.startsWith("(")){
           
           return u+getCorrect(p.substring(idx,p.length()));
        }else{
           
            return "("+getCorrect(p.substring(idx,p.length()))+")"+getChange(u);
        }
    }
    
    public String getChange(String u){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
    
}