class Solution {
    static int[][] dg;
    static int answer=Integer.MIN_VALUE;
    static boolean[] visitied;
    public int solution(int k, int[][] dungeons) {
        
        dg=dungeons;
        visitied=new boolean[dungeons.length];
        getMaxDungeon(k,0,0);
        return answer;
    }

    private static void getMaxDungeon(int tired,int idx,int L) {
        if(L==dg.length){
            answer=L;
            return;
        }

        for(int i=0;i<dg.length;i++){
            if(!visitied[i]){
                if(dg[i][0]<=tired) {
                    visitied[i] = true;
                    getMaxDungeon(tired - dg[i][1], i + 1,L+1);
                    visitied[i] = false;
                }else{
                    answer=Math.max(answer,L);
                }
            }
        }
    }
}