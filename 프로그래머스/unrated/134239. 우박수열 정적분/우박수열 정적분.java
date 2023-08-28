import java.util.*;
class Solution {
    static LinkedList<Double> list=new LinkedList<>();
    static int count=1;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        getWooBak(k);    
        getResult(answer,ranges);
        return answer;
    }
    public void getResult(double[] result, int[][] ranges){
        int idx=0;
        for(int [] range:ranges){
            if(range[1]<=0){
                range[1]+=count;
            }
            
            if(range[0]>range[1]){
                result[idx]=-1;
            }else if(range[0]==range[1]){
                result[idx]=0;
            }else{
                double sum=0;
                for(int i=range[0];i<range[1];i++){
                    sum+=list.get(i);
                }
                result[idx]=sum;
            }
            idx++;
        }
    }
    
    public void getWooBak(int num){
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ad.add(num);
        
        while(true){
            int k=ad.pollFirst();
            
            if(k==2){
                list.add((k+1)/2.0);
                break;
            }
            
            int next=0;
            if(k%2==0){
                next=k/2;
            }else if(k%2==1){
                next=k*3+1;
            }
            
            list.add((k+next)/2.0);
            ad.add(next);
            count++;
        }
    }
    
}