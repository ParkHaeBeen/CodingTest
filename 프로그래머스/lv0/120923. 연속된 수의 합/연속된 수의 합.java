import java.util.Arrays;
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int k=total;
        if(total==0){
            int ban=num/2;
            System.out.print(ban);
            for(int i=0;i<num;i++){
              answer[i]=ban;
              ban--;
          }
        } else {
            while (true) {
                int pr = 0;
                for (int i = 0; i < num; i++) {
                    pr += (k - i);
                }
                
                if (pr == total) {
                    for (int i = 0; i < num; i++) {
                        answer[i] = (k - i);
                    }
                    break;
                }
                k--;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}