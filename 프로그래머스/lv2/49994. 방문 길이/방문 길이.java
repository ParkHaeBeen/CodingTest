class Solution {
    static boolean[][][][] visited=new boolean[11][11][11][11];
    public int solution(String dirs) {
        int answer = 0;
        char[] ways=dirs.toCharArray();
        int nowx=5;
        int nowy=5;
        int prex=5;
        int prey=5;
        for(char way:ways){
            if(way=='U'){
                if(nowx<0||nowx>10||nowy+1<0||nowy+1>10) continue;
                nowy+=1;
                if(!visited[prex][prey][nowx][nowy]){
                    visited[prex][prey][nowx][nowy]=true;
                    answer++;
                }
                prex=nowx;
                prey=nowy;
            }else if(way=='D'){
                if(nowx<0||nowx>10||nowy-1<0||nowy-1>10) continue;
                nowy-=1;
                if(!visited[nowx][nowy][prex][prey]){
                    visited[nowx][nowy][prex][prey]=true;
                    answer++;
                }
                prex=nowx;
                prey=nowy;
            }else if(way=='R'){
                if(nowx+1<0||nowx+1>10||nowy<0||nowy>10) continue;
                nowx+=1;
                if(!visited[prex][prey][nowx][nowy]){
                    visited[prex][prey][nowx][nowy]=true;
                    answer++;
                }
                prex=nowx;
                prey=nowy;
            }else{
                if(nowx-1<0||nowx-1>10||nowy<0||nowy>10) continue;
                nowx-=1;
                if(!visited[nowx][nowy][prex][prey]){
                    visited[nowx][nowy][prex][prey]=true;
                    answer++;
                }
                prex=nowx;
                prey=nowy;
            }
        }
        return answer;
    }
}