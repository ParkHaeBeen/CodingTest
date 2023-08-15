class Solution {
    public int solution(int n) {
        
        boolean[] arr=new boolean[n+1];
        
        for(int i=2;i*i<=n;i++){
            if(arr[i]==false) {
                for (int k =i* i; k <= n; k += i) {
                    arr[k]=true;
                }
            }
        }
        int answer=0;
        for (int i=2;i<arr.length;i++) {
            if(arr[i]==false){
                answer++;
            }
        }
        return answer;
    }
}