class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int odd=0;
        
        int min=(int)Math.floor(Math.sqrt(left));
        while(true){
            if(min*min>=left&&min*min<=right){
                odd+=min*min;
            }else if(min*min>right){
                break;
            }
            min++;
        }

        answer=right*(right+1)/2-(left-1)*left/2-2*odd;
        return answer;
    }
}