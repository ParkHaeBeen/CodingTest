class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2==0){
            int idx=s.length()/2;
            answer=s.substring(idx-1,idx+1);
        }else{
            int idx=(int)Math.ceil(s.length()/2);
            answer=s.substring(idx,idx+1);
        }
        return answer;
    }
}