class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr=new int[n+2];
        for(int i=1;i<n+1;i++){
            arr[i]=1;
        }
        for(int lostP:lost){
            arr[lostP]-=1;
        }
        for(int re:reserve){
            arr[re]+=1;
        }
        
        for(int i=1;i<=n;i++){
            if(arr[i]==0){
                if(arr[i-1]==2){
                    arr[i-1]=1;
                    answer++;
                }else if(arr[i+1]==2){
                    arr[i+1]=1;
                    answer++;
                }
            }else if(arr[i]>=1){
                answer++;
            }
        }
        return answer;
    }
}