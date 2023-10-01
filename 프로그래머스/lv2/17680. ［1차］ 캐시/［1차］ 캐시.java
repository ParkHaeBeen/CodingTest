import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> citinames=new LinkedList<>();
        for(String city:cities){
            city=city.toUpperCase();
            if(citinames.contains(city)){
                answer+=1;
                citinames.remove(city);
                citinames.add(city);
                if(citinames.size()>cacheSize){
                    citinames.removeFirst();
                }

            }else{
                answer+=5;
                citinames.add(city);
                if(citinames.size()>cacheSize){
                    citinames.removeFirst();
                }

            }
        }
        return answer;
    }
}