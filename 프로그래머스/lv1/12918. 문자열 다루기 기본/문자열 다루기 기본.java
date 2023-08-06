class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()!=4&&s.length()!=6){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            answer=Character.isDigit(c);
            if(answer==false){
                break;
            }
        }
        return answer;
    }
}