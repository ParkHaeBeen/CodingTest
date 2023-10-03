class Solution {
    public int solution(int n) {
        int answer = 0;

      
        int cnt=0;
        for(int i=1;i<=n;i++){      
            if(i%2!=0&&n%i==0){
               //System.out.println(i);
                cnt+=1;
            }         
        }        
        
      
        answer=cnt;
        return answer;
    }
}