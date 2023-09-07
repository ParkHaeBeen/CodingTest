class Solution {
    static int[][] dir={
            {0,2},{2,0},{1,1},{0,-2},{-2,0},{-1,-1},{1,-1},{-1,1},{0,1},{1,0},{0,-1},{-1,0}
    };
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][]map=new char[5][5];
        int idx=0;
        for(int i=0;i<places.length;i++){
            for(int k=0;k<places[0].length;k++){
                for(int h=0;h<5;h++){
                    char ch=places[i][k].charAt(h);
                    map[k][h]=ch;
                }
            }
            int checkDistance = getCheckDistance(map);
            if(checkDistance==1){
                answer[idx++]=1;
            }else{
                answer[idx++]=0;
            }
        }

        return answer;
    }

    private static int getCheckDistance(char[][] map) {
        int answer=1;
        for(int i=0;i<map.length;i++){
            for(int k=0;k<map[0].length;k++){
                if(map[i][k]=='P'){
                    boolean check = checkDistance(i, k, map);
                    if(!check){
                        return 0;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean checkDistance(int y, int x, char[][] map) {
        boolean answer=true;
        Loop:
        while(true){
            for (int[] ints : dir) {
                int newY=y+ints[0];
                int newX=x+ints[1];
                if(newX<0||newY<0||newY>=5||newX>=5) continue;
                if(map[newY][newX]=='P'){
                    if(newX==x&&Math.abs(newY-y)>=2){
                        if(map[(newY+y)/2][newX]!='X'){
                            answer=false;
                            break Loop;
                        }
                    }else if(newY==y&&Math.abs(newX-x)>=2){
                        if(map[y][(newX+x)/2]!='X'){
                            answer=false;
                            break Loop;
                        }
                    }else if(Math.abs(newX-x)+Math.abs(newY-y)>=2){
                        if(map[newY][x]!='X'||map[y][newX]!='X'){
                            answer=false;
                            break Loop;
                        }
                    }else{
                        answer=false;
                        break Loop;
                    }
                }
            }
            break ;
        }
        return answer;
    }
}