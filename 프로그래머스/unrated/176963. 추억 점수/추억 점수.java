import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        Map<String,Integer> list= new HashMap<>();
        for(int i=0;i<name.length;i++){
            list.put(name[i],yearning[i]);
        }

        int index=0;
        for (String[] photoNames : photo) {
            for (String photoName : photoNames) {
                if(list.containsKey(photoName)){
                    answer[index]+=list.get(photoName);
                }
            }
            index++;
        }       
        return answer;
    }
}