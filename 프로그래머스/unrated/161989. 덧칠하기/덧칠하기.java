class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int size=section.length;
        int last=section[size-1];
        for(int i=0;i<section.length;i++){
            int color=section[i]+m-1;
            if(color>=last){
                answer++;
                break;
            }
            while(true){
                if(i+1>=size){
                    break;
                }
                if(color>=section[i+1]){
                    i++;

                }else{
                    break;
                }
            }
            answer++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}