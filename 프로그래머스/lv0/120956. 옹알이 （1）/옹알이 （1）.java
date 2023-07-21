class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can=new String[]{ "aya", "ye", "woo", "ma"};
        for (String s1 : babbling) {
            StringBuilder sb=new StringBuilder(s1);
            for (String s : can) {
                int index = sb.indexOf(s);
                if(index!=-1){
                    sb.replace(index,index+s.length()," ");
                }
            }
            String string = sb.toString().trim();
            if(string.length()==0){
                answer++;
            }
        }
        return answer;
    }
}