class Solution {
     static char[] alpha={'A','E','I','O','U'};
    static String find;
    static int answer=0;
    static int result=0;
    public static int solution(String word) {

        StringBuilder sb=new StringBuilder();
        find=word;
        getNumber(0,sb);
        return result;
    }

    private static void getNumber(int count,StringBuilder sb) {
        if(sb.toString().equals(find)){
            result=answer;
            return;
        }else if(count==5){
            return;
        }

        for(int i=0;i<5;i++){
            sb.append(alpha[i]);
            answer++;
            getNumber(count+1,sb);
            int index = sb.lastIndexOf(String.valueOf(alpha[i]));
            sb.deleteCharAt(index);
        }
    }
}