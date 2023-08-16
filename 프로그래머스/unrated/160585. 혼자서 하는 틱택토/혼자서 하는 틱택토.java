class Solution {
    static char[][] bd;
    static int[] dirX=new int[]{0,0,1,-1,1,-1,1,-1};
    static int[] dirY=new int[]{1,-1,0,0,1,1,-1,-1};
    static boolean[][] vistied;
    static boolean owin;
    static boolean xwin;
    static boolean doub;
    public int solution(String[] board) {
        int answer = 0;
        bd=new char[board.length][board[0].length()];
        vistied=new boolean[board.length][board[0].length()];
        int idx=0;
        for (String bb : board) {
            for(int i=0;i<bb.length();i++){
                char c = bb.charAt(i);
                bd[idx][i]=c;
            }
            idx++;
        }


        int ocnt=0;
        int xcnt=0;
        for(int i=0;i<bd.length;i++) {
            for (int k = 0; k < bd.length; k++) {
                if (bd[i][k] == 'O') {
                    find(k, i, bd[i][k]);
                    ocnt++;
                } else if (bd[i][k] == 'X') {
                    find(k,i,bd[i][k]);
                    xcnt++;
                }
            }
            
        }
        if(owin&&xwin){
            return answer;
        }else if(owin&&xwin==false){
            if(xcnt==ocnt-1){
                answer=1;
            }
        }else if(owin==false&&xwin){
            if(ocnt==xcnt){
                answer=1;
            }
        }else{

             if(ocnt==xcnt||ocnt==xcnt+1){
                 answer=1;
             }
        }
        System.out.println(answer);
        return answer;
    }

    private static void find(int x, int y, char c) {

        for(int i=0;i<8;i++){
            int cnt=0;
            int newX=x;
            int newY=y;
            while(true){
                newX= newX+dirX[i];
                newY=newY+dirY[i];
                if(newX<0||newY<0||newY>=3||newX>=3) break;

                
                    if(bd[newY][newX]==c) {
                        
                        cnt++;
                    }else{
                        break;
                    }
                

            }
            if(cnt==2){
                if(c=='O'){
                    if(owin){
                        doub=true;
                    }else {
                        owin = true;
                    }
                }else{
                    xwin=true;
                }
                break;
            }
        }
    }
}