class Solution {
    static int answer=0;
    public int solution(int n) {
        
        for(int i=0;i<n;i++){
            boolean[][] map=new boolean[n][n];
            map[0][i]=true;
            getQueen(map,1);
            
        }
        return answer;
    }
    
    void getQueen(boolean[][] map,int depth){
        if(depth==map.length){
            answer++;         
            return;
        }
        
      
        for(int x=0;x<map.length;x++){
            boolean existQueen=getCheck(x,depth,map);
            if(existQueen){
               map[depth][x]=true;
               getQueen(map,depth+1);
               map[depth][x]=false;
            }
        }
    
    }
    
    boolean getCheck(int x, int y,boolean[][]map){
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        
        for(int []d:dir){
            int newx=x;
            int newy=y;
            while(true){
                
                newx+=d[0];
                newy+=d[1];
                
                if(newx<0||newy<0||newx>=map.length||newy>=map.length) break;
                
                if(map[newy][newx]){
                    return false;
                }
            }
        }
        return true;
    }
}