class Solution {
    public int solution(String s) {
        int answer = 0;
        int count1=0;
        int count2=0;
        String first="";
        
        String[] split=s.split("");
        for(int i=0;i<split.length;i++){
            if(first.equals("")){
                first=split[i];
            }

            if(first.equals(split[i])){
                count1++;
            }else{
                count2++;
            }
 
            if(count1==count2){
                answer++;
                count2=0;
                count1=0;
                first="";
            }else if(i==split.length-1&&count2!=count1){
                answer++;
            }
        }
        
        return answer;
    }
}