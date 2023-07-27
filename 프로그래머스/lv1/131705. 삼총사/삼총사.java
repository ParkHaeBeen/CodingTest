class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i=0;i<number.length-2;i++){
            int index=i+1;
            while(index!=number.length-1){
                int find=number[i]+number[index];
                for(int k=index+1;k<number.length;k++){
                    if(number[k]==-find){
                        answer++;
                       
                    }
                }
                index++;
            }
        }
        return answer;
    }
}