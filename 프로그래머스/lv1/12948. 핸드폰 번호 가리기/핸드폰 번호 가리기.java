class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String last=phone_number.substring(phone_number.length()-4,phone_number.length());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<phone_number.length()-4;i++){
            sb.append("*");
        }
        answer=sb.toString()+last;
        return answer;
    }
}