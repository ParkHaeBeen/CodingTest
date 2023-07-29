class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long allNeed=0;
        for(int i=1;i<=count;i++){
            allNeed+=price*i;
        }
        answer=allNeed-money<0?0:allNeed-money;
        

        return answer;
    }
}