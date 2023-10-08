import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        ArrayDeque<Point> points=new ArrayDeque<>();
        points.add(new Point(0,0));
        
        int endx=maps[0].length-1;
        int endy=maps.length-1;
        
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited=new boolean[endy+1][endx+1];
        int cnt=0;
        boolean flag=false;
        visited[0][0]=true;
        Loop:
        while(!points.isEmpty()){
            int length=points.size();
            for(int i=0;i<length;i++){
                Point now=points.pollFirst();
                if(now.x==endx&&now.y==endy){
                    flag=true;                 
                    break Loop;
                }
                

                for(int[] dirs:dir){
                    int newx=now.x+dirs[0];
                    int newy=now.y+dirs[1];
                    
                    if(newx<0||newy<0||newx>=endx+1||newy>=endy+1||maps[newy][newx]==0
                         ||visited[newy][newx]) continue;
                    //System.out.println(newx+" "+newy);
                    points.add(new Point(newx,newy));
                    visited[newy][newx]=true;

                }
            }
            //System.out.println("=========");
            cnt++;
        }

        if(flag){
            answer=cnt+1;
        }else{
            answer=-1;
        }
        return answer;
    }
}
class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}