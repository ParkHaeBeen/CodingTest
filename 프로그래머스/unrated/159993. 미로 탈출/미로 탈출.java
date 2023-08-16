import java.util.ArrayDeque;

class Solution {
    static boolean[][] map;
    static int[] dirX={0,0,1,-1};
    static int[] dirY={1,-1,0,0};
    static int Ly,Lx,Sy,Sx,Ey,Ex,answer;
    public static int solution(String[] maps) {

        boolean[][]map=new boolean[maps.length][maps[0].length()];
        int idx=0;
        for (String m : maps){
            for(int i=0;i<m.length();i++){
                char c = m.charAt(i);
                if(c=='O'||c=='S'||c=='E'||c=='L'){
                    map[idx][i]=true;
                }
                if(c=='S'){
                    Sy=idx;
                    Sx=i;
                }else if(c=='E'){
                    Ey=idx;
                    Ex=i;
                } else if (c == 'L') {
                    Ly=idx;
                    Lx=i;
                }
            }
            idx++;
        }
        boolean[][] copy = new boolean[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            copy[i] =map[i].clone();
        }
        answer=0;
        map[Sy][Sx]=false;
        find(Sy,Sx,Ly,Lx,map,0);
        int result=answer;
        if(answer==0){
            return -1;
        }
        find(Ly,Lx,Ey,Ex,copy,0);
        if(result==answer){
            return -1;
        }
        return answer;
    }

    private static void find(int sy, int sx, int ly, int lx, boolean[][] map,int L) {
        ArrayDeque<GMap> list=new ArrayDeque<>();
        list.add(new GMap(sy,sx,L));
        int result=0;
        Loop:
        while(!list.isEmpty()){
            int length=list.size();
            for(int i=0;i<length;i++){
                GMap poll = list.poll();
                int y=poll.y;
                int x=poll.x;
                if(x==lx&&y==ly){
                    result=poll.cnt;
                    break Loop;
                }

                for(int k=0;k<4;k++){
                    int newY=y+dirY[k];
                    int newX=x+dirX[k];


                    if(newX<0||newY<0||newX>=map[0].length||newY>=map.length){
                        continue;
                    }

                    if(map[newY][newX]){
                        map[newY][newX]=false;
                        list.add(new GMap(newY,newX, poll.cnt+1));
                    }
                }
            }

        }

        answer+=result;
    }

}

class GMap{
    int y,x,cnt;

    public GMap(int y, int x,int cnt) {
        this.y = y;
        this.x = x;
        this.cnt=cnt;
    }
}