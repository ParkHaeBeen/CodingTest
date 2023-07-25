import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
       String answer = "";
        LinkedList<Character> list= new LinkedList<>();
        for(int i=97;i<123;i++){
            list.add((char)i);
        }

        char[] charArray = skip.toCharArray();
        for (char c : charArray) {
            if(list.contains(c)){
                int i = list.indexOf((char) c);
                list.remove(i);

            }
        }



        char[] charArray1 = s.toCharArray();
        for (char c : charArray1) {
            int indexOf = list.indexOf(c)+index;
            System.out.println("indexOf = " + indexOf);
            System.out.println("list = " + list.size());
            if(indexOf>list.size()-1){
                answer+=list.get(indexOf%list.size());
            }else{
                answer+=list.get(indexOf);
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}