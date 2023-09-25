import java.util.*;
class Solution {
    static int answer=0;
    static Set<Integer> nums=new HashSet<>();
    public int solution(String numbers) {
        for(int i=1;i<=numbers.length();i++){
            int[] com=new int[i];
            boolean[] visited=new boolean[numbers.length()];
            get(i,numbers,0,com,visited);
        }
        return answer;
    }
    
    public void get(int length,String numbers, int L,int[]arr,boolean[] visited){
        if(length==L){
            StringBuilder sb=new StringBuilder();
            for(int idx:arr){
                sb.append(numbers.charAt(idx));
            }
            int num=Integer.parseInt(sb.toString());
            if(num<=1){
                return;
            }
            
            if(getIsPrime(num)){
                answer++;
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                arr[L]=i;
                visited[i]=true;
                get(length,numbers,L+1,arr,visited);
                visited[i]=false;
            }
        }
    }
    
    public boolean getIsPrime(int num){
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        
        if(nums.contains(num)){
            return false;
        }
        nums.add(num);
        return true;
    }
}