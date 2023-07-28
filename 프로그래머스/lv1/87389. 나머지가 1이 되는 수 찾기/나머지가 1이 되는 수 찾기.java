class Solution {
    public int solution(int n) {
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=2;i--){
            if((n-1)%i==0&&min>i){
                min=i;
            }
        }

        return min;
    }
}