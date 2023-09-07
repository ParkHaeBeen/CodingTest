class Solution {
static double[] rate={60,70,80,90};
    static int[] com;
    static int[][] user;
    static int realusers,moneysum;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        user=users;
        com=new int[emoticons.length];
        getCombi(emoticons,0);
        answer[0]=realusers;
        answer[1]=moneysum;
        return answer;
    }

    private void getCombi(int[] emoticons, int L) {
        if(L==emoticons.length){
            getMax(com,emoticons);
            return;
        }
        
        for(int i=0;i<rate.length;i++){
            com[L]=i;
            getCombi(emoticons,L+1);
        }
    }

    private void getMax(int[] com, int[] emoticons) {
        int joinuser=0;
        int totalmoney=0;
        for (int[] ints : user) {
            int sum=0;
            for(int i=0;i<com.length;i++){
                if(ints[0]<=(100-rate[com[i]])){
                    sum+=emoticons[i]*rate[com[i]]/100;
                }
            }
            
            if(sum>=ints[1]){ 
                joinuser++;
            }else{
                totalmoney+=sum;
            }
        }
        if(joinuser>realusers){
            realusers=joinuser;
            moneysum=totalmoney;
        }else if(joinuser==realusers){
            if(totalmoney>moneysum){
                moneysum=totalmoney;
            }
        }
    }
}