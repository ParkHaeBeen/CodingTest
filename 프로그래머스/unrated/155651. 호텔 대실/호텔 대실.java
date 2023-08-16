import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
            int answer = 0;
            LinkedList<Time> pq=new LinkedList<>();
            for(String[] time:book_time){
                String startT=time[0];
                String endT=time[1];

                String[] startTsplit=startT.split(":");
                String[] endTsplit=endT.split(":");
                int start=Integer.parseInt(startTsplit[0])*60+Integer.parseInt(startTsplit[1]);
                int end=Integer.parseInt(endTsplit[0])*60+Integer.parseInt(endTsplit[1])+10;
                pq.add(new Time(start,end));
            }

            Collections.sort(pq);

            while(!pq.isEmpty()){
                if(pq.size()==1){
                    answer++;
                    break;
                }

                Time poll = pq.poll();
                int endT=poll.end;
                int idx=0;

                boolean flag=false;
                while(idx<=pq.size()-1){
                    int start=pq.get(idx).start;

                    if(start>=endT){
                        Time remove=pq.remove(idx);
                        if(flag==false) {
                            answer++;
                        }
                        endT=remove.end;
                        flag=true;
                        idx=-1;
                    }
                    idx++;


                    if(idx== pq.size()){
                        if(flag==false) {
                            answer++;
                        }
                        break;
                    }
                }
            }
            return answer;
    }
}
class Time implements Comparable<Time>{
    int start,end;
    
    public Time(int start,int end){
        this.start=start;
        this.end=end;
    }
    
    @Override
    public int compareTo(Time t){
        return this.start-t.start;
    }
}