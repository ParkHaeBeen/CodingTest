import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
         Map<String,Integer> playersGrade=new HashMap<>();
        int grade=0;
        for (String player : players) {
            playersGrade.put(player,grade++);
        }

        for (String calling : callings) {
            Integer nowGrade = playersGrade.get(calling) - 1;

            
            String foward=players[nowGrade];
            
            players[nowGrade]=calling;
            playersGrade.put(calling, nowGrade);
            
            players[nowGrade+1]=foward;
            playersGrade.put(foward,nowGrade+1);
        }
        

        return players;
    }
}