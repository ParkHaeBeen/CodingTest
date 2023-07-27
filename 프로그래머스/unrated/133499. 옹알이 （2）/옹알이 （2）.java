import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babb:babbling){
            LinkedList<String> list= new LinkedList(Arrays.asList("aya", "ye", "woo", "ma"));
            StringBuilder sb= new StringBuilder(babb);
            String replace="";
            for(String can:list){
                
                int index=sb.indexOf(can);
                 while(sb.indexOf(can)!=-1){

                    sb.replace(index,index+can.length()," ");
                    if(sb.indexOf(can)==(index+1)){
                        break;
                    }
                    index= sb.indexOf(can);
                }
                
                replace = sb.toString().replace(" ", "");
                if(replace.length()==0){
                    break;
                }
            }
            
            if(replace.length()==0){
                answer++;
            }
        }
        return answer;
    }
}