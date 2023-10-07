import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int common=0;
        int all=0;
        
        str1=str1.replaceAll("[^a-zA-Z]","1").toUpperCase();
        str2=str2.replaceAll("[^a-zA-Z]","1").toUpperCase();
        List<String> firstStr=new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            String st=str1.substring(i,i+2);
            if(st.indexOf("1")!=-1) continue;
            
            firstStr.add(st);
        }
        
        List<String> secondStr=new ArrayList<>();
        for(int i=0;i<str2.length()-1;i++){
            String st=str2.substring(i,i+2);
            if(st.indexOf("1")!=-1) continue;
            
            secondStr.add(st);
        }
        Collections.sort(firstStr);
        Collections.sort(secondStr);
        
       
        for(int i=0;i<firstStr.size();i++){
            if(secondStr.contains(firstStr.get(i))){
                common++;    
                secondStr.remove(firstStr.get(i));
            }
        }
        all=firstStr.size()+secondStr.size();
        //System.out.println(common+" "+all);
        if(all==0){
            return 65536;
        }
        answer=(int)((common/(double)all)*65536);
        return answer;
    }
}