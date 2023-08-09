class Solution {
    public String solution(String s, int n) {
      String answer = "";
        char[] charArray = s.toCharArray();
        StringBuilder sb= new StringBuilder();
        for (char c : charArray) {
            if(c==' '){
                sb.append(c);
            }else{
                if(c>=65&&c<=90){
                    int num=c+n;
                    num=num>90?num%90+64:num;
                    sb.append((char)num);
                }else{
                    int num=c+n;
                    num=num>=123?num%122+96:num;

                    sb.append((char)num);
                }
            }
        }
        
        return sb.toString();
    }
}