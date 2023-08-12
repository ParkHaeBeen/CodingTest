import java.util.stream.*;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(b<a){
            int tmp=a;
            a=b;
            b=tmp;
        }
        answer=LongStream.range(a,b+1).sum();
        return answer;
    }
}