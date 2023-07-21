import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        double[] answer = new double[score.length];
        
        for(int i=0;i<score.length;i++){
            int avg=0;
            for(int k=0;k<score[0].length;k++){
                avg+=score[i][k];
            }
            answer[i]= (avg/2.0);
        }

        TreeMap<Double,Integer> list= new TreeMap<>(Comparator.reverseOrder());
        
        for (double i : answer) {
            if(list.containsKey(i)){
                System.out.println("\"DDD\" = " + "DDD");
                list.put(i,(list.get(i)+1));
            }else{
                list.put(i,1);
            }
        }

        int grade=1;
        for (Map.Entry<Double, Integer> integerIntegerEntry : list.entrySet()) {
            int check=integerIntegerEntry.getValue();
            double param=integerIntegerEntry.getKey();
            if(check>=2){
                integerIntegerEntry.setValue(grade);
                grade=grade+check;
            }else{
                integerIntegerEntry.setValue(grade);
                grade++;
            }
        }


        int [] re=new int[score.length];
        
        int index=0;
        for (double i : answer) {
            Integer integer = list.get(i);
            re[index] = integer;
            index++;
        }
        for (int i : re) {
            System.out.println("i = " + i);
        }


        return re;
    }
}