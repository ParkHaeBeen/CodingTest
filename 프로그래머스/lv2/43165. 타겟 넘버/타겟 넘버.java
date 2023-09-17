class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        getCountTarget(numbers,target,0,0);
        return answer;
    }

    public void getCountTarget(int[] numbers, int target,int idx, int sum){
        if(idx==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        
        getCountTarget(numbers,target,idx+1,sum+numbers[idx]);
        getCountTarget(numbers,target,idx+1,sum-numbers[idx]);
    }
}