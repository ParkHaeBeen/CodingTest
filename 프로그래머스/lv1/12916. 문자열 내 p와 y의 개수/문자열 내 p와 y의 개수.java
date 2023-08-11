class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] chs=s.toCharArray();
        int p=0;
        int y=0;
        for(char ch:chs){
            if(ch=='Y'||ch=='y'){
                y++;
            }else if(ch=='P'||ch=='p'){
                p++;
            }
        }
        if(p!=y){
            answer=false;
        }
        return answer;
    }
}