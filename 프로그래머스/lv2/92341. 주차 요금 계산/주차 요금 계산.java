import java.util.*;
class Solution {
    static int basicTime,basicFee,time,fee;
    static int maxTime=1439;
    static LinkedList<CarPark> parks=new LinkedList<>();
    static LinkedList<Integer> carFees=new LinkedList<>();
    public int[] solution(int[] fees, String[] records) {
        basicTime=fees[0];
        basicFee=fees[1];
        time=fees[2];
        fee=fees[3];

        for(String record:records){
            String[] perPark=record.split(" ");
            int parkT =Integer.parseInt(perPark[0].substring(0,2))*60+Integer.parseInt(perPark[0].substring(3,5));
            int carNum=Integer.parseInt(perPark[1]);
            char c=perPark[2].charAt(0);
            parks.add(new CarPark(parkT,carNum,c));
        }
        Collections.sort(parks);
        while(!parks.isEmpty()){
            CarPark now=parks.pollFirst();
            int sumTime=0;
            int inTime=now.start;
            boolean flag=false;
            while(!parks.isEmpty()&&parks.peekFirst().number==now.number){
                CarPark next = parks.pollFirst();
                if(next.way=='I'){
                    inTime=next.start;
                    flag=false;
                }else {
                    sumTime+=next.start-inTime;
                    inTime=0;
                    flag=true;
                }
            }
          
            if(!flag){
                sumTime+=maxTime-inTime;
            }
            
            getParkFee(sumTime);
        }

        int[] answer = new int[carFees.size()];
        
        int idx=0;
        for (int i :  carFees) {
            answer[idx++]=i;
        }
        return answer;
    }

    private void getParkFee(int sumTime) {
        int totalFee=basicFee;
        if(sumTime>basicTime){
            totalFee+=Math.ceil(((double)sumTime-basicTime)/time)*fee;
        }
        carFees.add(totalFee);
    }
}
class CarPark implements Comparable<CarPark>{
    int start;
    int number;
    char way;
    
    public CarPark(int start,int number,char way){
        this.start=start;
        this.number=number;
        this.way=way;
    }
    
    @Override
    public int compareTo(CarPark cp){
        if(cp.number==this.number){
            return this.start-cp.start;
        }
        return this.number-cp.number;
    }
}