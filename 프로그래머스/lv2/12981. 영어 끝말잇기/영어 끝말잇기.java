import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordCheck=new HashSet<>();
        int breakIdx=0;
        boolean flag=false;
        char prechar=' ';
        for(int i=0;i<words.length;i++){     
            String nowWord=words[i];
            
            if(prechar!=' '&&nowWord.charAt(0)!=prechar){
                breakIdx=i;
                flag=true;
                break;
            }
            if(wordCheck.contains(nowWord)){
                breakIdx=i;
                flag=true;
                break;
            }
            
            wordCheck.add(nowWord);
            prechar=nowWord.charAt(nowWord.length()-1);
        }
        if(!flag){
            return new int[]{0,0};
        }

        answer[0]=breakIdx%n+1;
        answer[1]=breakIdx/n+1;

        return answer;
    }
}