class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs=s.split(" ");
    
        for(int i=0;i<strs.length;i++){
            String word=strs[i];
            if(word.length()==0){
                answer+=" ";
                continue;
            }
            word=word.toLowerCase();
            String first=word.substring(0,1).toUpperCase();
            answer+=first+word.substring(1,word.length())+" ";
        }
        boolean first=false;
        boolean last=false;
        if(answer.startsWith(" ")){
            first=true;
        }
        if(s.endsWith(" ")){
            last=true;
        }
        answer=answer.trim();
        
        if(first){
            answer=" "+answer;
        }
        if(last){
            answer=answer+" ";
        }
        return answer;
        
    }
}