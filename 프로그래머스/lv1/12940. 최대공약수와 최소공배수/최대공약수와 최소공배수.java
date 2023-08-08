class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0]=findMax(n,m);
        answer[1]=findMin(n,m);
        return answer;
    }
    
    private int findMax(int x, int y){
        int small=x>=y?y:x;
        int answer=0;
        for(int i=small;i>0;i--){
            if(x%i==0&&y%i==0){
                answer=i;
                break;
            }
        }
        return answer;
    }
    
    private int findMin(int x, int y){
        int big=x>=y?x:y;
        int answer=0;
        int idx=1;
        while(true){
            int num=big*idx;
            if(num%x==0&&num%y==0){
                answer=num;
                break;
            }
            idx++;
        }
        return answer;
    }
}