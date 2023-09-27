import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Truck> trucks=new ArrayDeque<>();
        int time=1;
        trucks.add(new Truck(1,truck_weights[0]));
        int nowWeight=truck_weights[0];
        int idx=1;
        while(idx<truck_weights.length){
            Truck now=trucks.peekFirst();
            //아직 다리에 있음
            if(now.time+bridge_length>time&&trucks.size()<bridge_length){
                if(nowWeight<weight){
                    int left=weight-nowWeight;
                    if(left>=truck_weights[idx]){
                        
                        trucks.add(new Truck(time,truck_weights[idx]));
                        nowWeight+=truck_weights[idx++];
                    }
                }
            }else{
                trucks.pollFirst();
                nowWeight-=now.weight;
                if(nowWeight<weight&&trucks.size()<bridge_length){
                    int left=weight-nowWeight;
                    if(left>=truck_weights[idx]){
                        trucks.add(new Truck(time,truck_weights[idx]));
                        nowWeight+=truck_weights[idx++];
                    }
                }
                //System.out.println(nowWeight+"==="+time);
                if(idx==truck_weights.length){
                    break;
                }
            }
            
            time++;   
            
            //System.out.println(time+" "+nowWeight+" "+idx);
        }
        time+=bridge_length;     
        return time;
    }
}
class Truck{
    int time,weight;
    
    public Truck(int time,int weight){
        this.time=time;
        this.weight=weight;
    }
}