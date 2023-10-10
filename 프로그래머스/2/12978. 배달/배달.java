import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Town>> townsCon=new ArrayList<>();
        for(int i=0;i<=N;i++){
            townsCon.add(new ArrayList<>());
        }
        
        for(int i=0;i<road.length;i++){
            int town1=road[i][0];
            int town2=road[i][1];
            int time=road[i][2];
            
            townsCon.get(town1).add(new Town(town2,time));
            townsCon.get(town2).add(new Town(town1,time));
        }
        
        PriorityQueue<Town> townsPq=new PriorityQueue<>();
        boolean[] visited=new boolean[N+1];
        visited[1]=true;
        
        for(int i=0;i<townsCon.get(1).size();i++){
            townsPq.add(townsCon.get(1).get(i));
        }
        
        int cnt=1;
        while(!townsPq.isEmpty()){
            Town now=townsPq.poll();
            int next=now.end;
            int time=now.time;
            if(visited[next]) continue;
            if(time<=K){
                cnt++;
            }else if(time>K){
                break;
            }
            
            visited[next]=true;
            
            for(int i=0;i<townsCon.get(next).size();i++){
                Town nextTown=townsCon.get(next).get(i);
                townsPq.add(new Town(nextTown.end,nextTown.time+time));
            }
        }
        

        return cnt;
    }
}
class Town implements Comparable<Town>{
    int end,time;
    
    public Town(int end,int time){
        this.end=end;
        this.time=time;
    }
    
    @Override
    public int compareTo(Town t){
        return this.time-t.time;
    }
}