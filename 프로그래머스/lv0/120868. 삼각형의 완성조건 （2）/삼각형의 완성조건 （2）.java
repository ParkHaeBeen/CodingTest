import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        int answer = 1;
        Arrays.sort(sides);
        int smallside=sides[1]-sides[0]+1;
         System.out.println("smallside = " + smallside);
        while(true){
        
            if(smallside==(sides[1]+sides[0]-1)){
                break;
            }
            smallside++;
            answer++;
        }
        
        
        
        return answer;
    }
}