class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        long colstart=left/n;
        long colend=right/n;
        int idx=0;

        for(long k=left;k<=right;k++){
            int row=(int)(k%n);

            if(colstart>=row){
                answer[idx++]= (int) colstart+1;
            }else{
                answer[idx++]=row+1;
            }
            
            if(k%n==n-1&&colstart<colend){
                colstart++;
            }
        }

        return answer;
    }
}