class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int index=0;
        for(String target:targets){
            String[] targetOne=target.split("");

            for(String one:targetOne){
               
                int min=Integer.MAX_VALUE;
                for(String key:keymap){
                    if(key.contains(one)&&min>key.indexOf(one)){
                        min=key.indexOf(one)+1;
                    }
                   
                }
                if(min==Integer.MAX_VALUE){
                    answer[index]=-1;
                    break;
                }
                answer[index]+=min;
            }
            index++;
        }
        
        return answer;
    }
}