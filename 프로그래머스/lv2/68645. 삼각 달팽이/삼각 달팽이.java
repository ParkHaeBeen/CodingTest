class Solution {
    static int[][] map;
    public static int[] solution(int n) {
        map=new int[n][n];
        int reach=n*(n+1)/2;
        int[] answer = new int[reach];
        getMap(n,reach,0,0,'d',1);
        int idx=0;
        for(int i=0;i<n;i++){
            for(int k=0;k<=i;k++){
                answer[idx++]=map[i][k];
            }
        }

        return answer;
    }

    private static void getMap(int length, int reach, int y, int x,char ch,int startNum) {
        if(startNum>reach){
            return;
        }
        if(ch=='d'){
            for(int i=0;i<length;i++){
                map[y+i][x]=startNum++;
            }

            getMap(length-1,reach,y+length-1,x+1,'s',startNum);

        }else if(ch=='s'){
            for(int i=0;i<length;i++){
                map[y][x+i]=startNum++;
            }

            getMap(length-1,reach,y-1,x+length-2,'u',startNum);
        }else if(ch=='u'){
            for(int i=0;i<length;i++){
                map[y-i][x-i]=startNum++;
            }
            getMap(length-1,reach,y-length+2,x-length+1,'d',startNum);
        }

    }
}