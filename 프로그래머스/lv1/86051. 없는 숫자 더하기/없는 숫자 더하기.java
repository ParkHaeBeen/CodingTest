class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int allSum=45;
        for(int i=0;i<numbers.length;i++){
            answer+=numbers[i];
        }
        answer=allSum-answer;
        return answer;
    }
}