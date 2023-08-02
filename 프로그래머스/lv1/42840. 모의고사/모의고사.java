import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] one=new int[]{1,2,3,4,5};
        int[] two=new int[]{2,1,2,3,2,4,2,5};
        int[] three=new int[]{3,3,1,1,2,2,4,4,5,5};

        int [] result= new int[3];
        for(int i=0;i<answers.length;i++){

            if(one[i%5]==answers[i]){
                result[0]+=1;
            }

            if(two[i%8]==answers[i]){
                result[1]+=1;
            }

            if(three[i%10]==answers[i]){
                result[2]+=1;
            }
        }
        int[] result2=result.clone();
        Arrays.sort(result);
        int MAX=result[2];

       List<Integer> list= new ArrayList<>();
        for(int i=0;i<result2.length;i++){
            if(result2[i]==MAX){
                list.add(i+1);
            }
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}