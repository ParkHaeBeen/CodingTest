import java.util.*;
class Solution {
   public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] grade=new int[]{3,2,1,0,1,2,3};
        HashMap<String,Integer> perGrade=new HashMap<>();
        perGrade.put("R",0);
        perGrade.put("T",0);
        perGrade.put("C",0);
        perGrade.put("F",0);
        perGrade.put("J",0);
        perGrade.put("M",0);
        perGrade.put("A",0);
        perGrade.put("N",0);

        int index=0;
        for(String sur:survey){
            if(choices[index]>4){
                String sel=String.valueOf(sur.charAt(1));
                
                perGrade.put(sel,perGrade.get(sel)+grade[choices[index]-1]);

            }else if(choices[index]<4){
                String sel=String.valueOf(sur.charAt(0));

                perGrade.put(sel,perGrade.get(sel)+grade[choices[index]-1]);

            }
            index++;
        }


        String one=getPersonal("R","T",perGrade);
        String two=getPersonal("C","F",perGrade);
        String three=getPersonal("J","M",perGrade);
        String four=getPersonal("A","N",perGrade);

        answer=one+two+three+four;
        return answer;
    }

    public static String getPersonal(String one, String two,HashMap<String,Integer> map){
        Integer sum1 = map.get(one);
        Integer sum2 = map.get(two);


        if(sum1>=sum2){
            return one;
        }

        return two;

    }
}