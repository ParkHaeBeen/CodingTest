import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int maxNum=getGCD(arrayA);
        if(maxNum!=Integer.MIN_VALUE&&getCheck(maxNum,arrayB)){
            answer=maxNum;
        };
        
        maxNum=getGCD(arrayB);
        if(maxNum!=Integer.MIN_VALUE&&getCheck(maxNum,arrayA)){
            answer=Math.max(answer, maxNum);
        }

        return answer;
    }
    
    public int getGCD(int[] arr){
        int num=arr[0];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                list.add(i);
                list.add(num/i);
            }else if(i*i==num){
                list.add(i);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int ar:list){
            boolean flag=false;
            for(int i=1;i<arr.length;i++){
                if(arr[i]%ar!=0){
                
                    flag=false;
                    break;
                }
                flag=true;
            }
            
            if(flag||arr.length==1){
                max=Math.max(max,ar);
            }
        }
        return max;
    }
    
    public boolean getCheck(int num,int[] arr){
        for(int a:arr){
            if(a%num==0){
                return false;    
            }
        }
        return true;
    }
    
}