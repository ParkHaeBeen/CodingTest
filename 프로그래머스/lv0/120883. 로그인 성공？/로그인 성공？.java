class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        String answer = "";
        for (String[] strings : db) {
            if(id_pw[0].equals(strings[0])){
                if(id_pw[1].equals(strings[1])){
                    answer="login";
                }else{
                    answer="wrong pw";
                }
                break;
            }else{
                answer="fail";
            }
        }
        return answer;
       
    }
}