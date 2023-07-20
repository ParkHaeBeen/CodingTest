import java.util.ArrayList;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        ArrayList<Integer> list= new ArrayList<>();

        for (String s : dic) {
            for(int i=0;i<spell.length;i++){
                if(s.contains(spell[i])){
                    answer++;
                    
                }
            }
            list.add(answer);
            answer=0;
        }

        int i = list.indexOf(spell.length);
        System.out.println("i = " + i);
        answer=i==-1?2:1;
        return answer;
    }
}