import java.util.*;
class Solution {
    static int answer=-1;
     static int max;
    public int solution(int[] queue1, int[] queue2) {
 ArrayDeque<Integer> ad1=new ArrayDeque<>();
        ArrayDeque<Integer> ad2=new ArrayDeque<>();

        int sum=0;
        long sumOne=0;
        long sumTwo=0;
        for(int i=0;i<queue2.length;i++){
            ad1.add(queue1[i]);
            ad2.add(queue2[i]);
            sumOne+=queue1[i];
            sumTwo+=queue2[i];
            sum+=queue2[i]+queue1[i];
        }

        int half=sum/2;
        max=(queue1.length+queue2.length)*2;
        getAnswer(half,sumOne,sumTwo,ad1,ad2);
        System.out.println(answer);
        return answer;
    }

    private static void getAnswer(int half, long sumOne, long sumTwo, ArrayDeque<Integer> ad1, ArrayDeque<Integer> ad2) {
        int count=0;
        while (sumOne!=sumTwo){
            if(max<count){
                count=-1;
                break;
            }
            if(sumOne<sumTwo){
                Integer num = ad2.pollFirst();
                sumOne+=num;
                sumTwo-=num;
                ad1.add(num);
            }else if(sumOne>sumTwo){
                Integer num = ad1.pollFirst();
                sumOne-=num;
                sumTwo+=num;
                ad2.add(num);
            }
            count++;
            
        }

        answer=count;
    }
}