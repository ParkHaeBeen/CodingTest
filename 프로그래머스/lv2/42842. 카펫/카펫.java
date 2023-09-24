class Solution {
    static int brownB;
    static int yellowB;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        brownB=brown;
        yellowB=yellow;
        int allblock=brown+yellow;
        
        for(int i=allblock/2;i>0;i--){
            if(allblock%i!=0) continue;
            if(getPossible(allblock,i)){
                answer[0]=allblock/i;
                answer[1]=i;
            }
        }
        return answer;
    }
    
    boolean getPossible(int allblock,int bottom){
        int side=allblock/bottom;
        while(side>0){
            bottom-=2;
            side-=2;
            int inyellow=bottom*side;
            if(inyellow<yellowB) return false;
            if(inyellow>yellowB) continue;
        
            if(allblock-inyellow!=brownB) return false;
            break;
        }
        
        return true;
    }
}