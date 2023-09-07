class Solution {
    public long[] solution(long[] numbers) {
long[] answer = new long[numbers.length];
        int answeridx=0;
        for (long number : numbers) {
            String binaryString = Long.toBinaryString(number);
            int idx=-1;
            for(int i=binaryString.length()-1;i>=0;i--){
                if(binaryString.charAt(i)=='0'){
                    idx=i;
                    break;
                }
            }
            
            if(number%2==0){
                answer[answeridx++]=number+1;
            }else{
                String result;
                if(idx==-1){
                    result="10"+binaryString.substring(1,binaryString.length());
                }else{
                    result=binaryString.substring(0,idx)+"10"+binaryString.substring(idx+2);
                }
                answer[answeridx++]=Long.parseLong(result,2);
            }
        }
        return answer;
    }
}