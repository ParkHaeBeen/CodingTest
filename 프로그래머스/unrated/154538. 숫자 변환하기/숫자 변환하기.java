import  java.util.*;
class Solution {
    static int[] arr;
    public int solution(int x, int y, int n) {
         if(x==y){
             return 0;
         }
        arr=new int[]{2,3};
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ad.add(y);
        
        int count=1;
        int[] dp=new int[y+1];
        Arrays.fill(dp,1000000);
        Loop:
        while(!ad.isEmpty()){
            int length=ad.size();
            for(int h=0;h<length;h++){
                int num=ad.pop();
                for(int i=0;i<3;i++){
                
                    if(i!=2){
                        if(num%arr[i]==0&&num/arr[i]>=x){
                            dp[num/arr[i]]=Math.min(dp[num/arr[i]]+1,count);
                            ad.add(num/arr[i]);
                            if(num/arr[i]==x){
                                 
                                break Loop;
                            }
                        }
                    }else{
                        if(num-n>=x){
                            dp[num-n]=Math.min(dp[num-n]+1,count);
                        
                            ad.add(num-n);
                            if(num-n==x){
                              
                                break Loop;
                            }
                        }
                    }
                }
            }
            count++;
        }
        
        if(dp[x]==1000000){
            return -1;
        }
        return dp[x];
    }
}