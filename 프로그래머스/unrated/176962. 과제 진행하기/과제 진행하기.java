import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<HomeWork> list =new PriorityQueue<>();

        for (String[] plan : plans) {
            String name=plan[0];
            String startString=plan[1];
            int end=Integer.parseInt(plan[2]);

            String[] split = startString.split(":");
            int start=Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
            list.add(new HomeWork(name,start,end));
        }


        ArrayDeque<HomeWork> left=new ArrayDeque<>();
        LinkedList<String> result=new LinkedList<>();
        HomeWork first=list.poll();
        String name= first.name;
        int start= first.start;
        int time=first.time;

        while(!list.isEmpty()){
            HomeWork next = list.poll();
            String nextName=next.name;
            int nextStart=next.start;
            int nextTime=next.time;

            //숙제를 다하지 못했을떄
            if(nextStart<start+time){
                int leftTime=start+time-nextStart;
                left.add(new HomeWork(name,start,leftTime));
            }else if(nextStart>start+time){
                int leftTime=nextStart-start-time;
                result.add(name);

                while(!left.isEmpty()){
                    
                    HomeWork leftWork = left.pollLast();
                    int doTime=leftWork.time-leftTime;
                    if(doTime==0){
                        result.add(leftWork.name);
                        break;
                    }else if(doTime>0){
                        left.add(new HomeWork(leftWork.name,leftWork.start,doTime));
                        break;
                    }else {
                        result.add(leftWork.name);
                        leftTime=-doTime;
                    }
                }
            }else if(nextStart==start+time){
                result.add(name);
            }

            if(list.size()==0){
                result.add(nextName);
            }
            
            name=nextName;
            start=nextStart;
            time=nextTime;
        }
        
        while(!left.isEmpty()){
            result.add(left.pollLast().name);
        }

        
        return result.toArray(new String[0]);
    }
}

class HomeWork implements Comparable<HomeWork>{
    String name;
    int start;
    int time;

    public HomeWork(String name, int start, int time) {
        this.name = name;
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(HomeWork o) {
        return this.start-o.start;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", time=" + time +
                '}';
    }
}