class Solution {
    static int tmp,min,startx,starty;
    static int[][]map;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map=new int[rows][columns];
        for(int i=1;i<=map.length;i++){
            for(int k=1;k<=columns;k++){
                map[i-1][k-1]=(i-1)*columns+k;
            }
        }

        int idx=0;
        for(int i=0;i<queries.length;i++){
            int xCount=queries[i][3]-queries[i][1];
            int yCount=queries[i][2]-queries[i][0];
            startx=queries[i][1];
            starty=queries[i][0];

            min=Integer.MAX_VALUE;
            tmp=map[starty-1][startx-1];

            getCircle('R',xCount);
            getCircle('D',yCount);
            getCircle('L',xCount);
            getCircle('U',yCount);
            answer[idx++]=min;
        }
        
        return answer;
    }

    private static void getCircle(char r,int xcount) {
        int x=0;
        int y=0;
        if(r=='R'){
            x=1;
        }else if(r=='D'){
            y=1;
        }else if(r=='L'){
            x=-1;
        }else{
            y=-1;
        }
        for(int i=0;i<xcount;i++){
            min=Math.min(min,tmp);
            int num=tmp;
            startx+=x;
            starty+=y;
            tmp=map[starty-1][startx-1];
            map[starty-1][startx-1]=num;
        }
        
    }
}