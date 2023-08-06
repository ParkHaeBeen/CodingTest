class Solution {
    static int[] arr=new int[3];
    static int answer=0;
    
    public int solution(int[] nums) {

        check(nums,0,0);

        return answer;
    }

    private void check(int[] nums, int i,int s) {

        if(i==3){
            int sum=0;
            for (int idx : arr) {
                sum+=nums[idx];
            }
            if(sum%2!=0){
                int count=0;
                for(int k=2;k*k<=sum;k++){
                    if(sum%k==0){
                        count++;
                    }
                    if(k*k==sum){
                        count++;
                    }
                }
                if(count==0){
                    answer++;
                }
            }
        }else{
            for(int k=s;k<nums.length;k++){
                arr[i]=k;
                check(nums,i+1,k+1);
            }
        }
    }
}