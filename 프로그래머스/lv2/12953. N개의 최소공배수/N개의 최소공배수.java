class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int gcd=getGCD(arr[arr.length-1],arr[arr.length-2]);
        if(gcd==0){
            gcd=1;
        }
        int num=arr[arr.length-1]*arr[arr.length-2]/gcd;
        for(int i=arr.length-3;i>=0;i--){
            int gcd2=getGCD(arr[i],num);
            if(gcd2==0){
                gcd2=1;
            }
            num=num*arr[i]/gcd2;
        }
        return num;
    }
    
    int getGCD(int a, int b){
        if(a%b==0){
            return b;
        }
        
        return getGCD(b,a%b);
    }
}