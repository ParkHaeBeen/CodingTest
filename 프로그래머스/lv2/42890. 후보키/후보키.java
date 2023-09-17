import java.util.*;
class Solution {
    static Set<int[]> keyCount=new HashSet<>();
    static String[][] rel;
    public int solution(String[][] relation) {
        rel=relation;
        for(int i=1;i<=relation[0].length;i++){
            int[] combi=new int[i];
            dfs(i,combi,0,0);
        }
        
        return keyCount.size();
    }
    
    public void dfs(int length,int[] combi,int L,int idx){
        if(L==length){
            getKey(combi);
            return;
        }
        
        for(int i=idx;i<rel[0].length;i++){
            combi[L]=i;
            dfs(length,combi,L+1,i+1);
        }
    }
    
   public void getKey(int[] combi){
    
        Set<String> keys=new HashSet<>();
        for(String[] rows:rel){
            StringBuilder sb=new StringBuilder();
            for(int idx:combi){
                sb.append(rows[idx]);
            }

            if(!keys.contains(sb.toString())){
                keys.add(sb.toString());
            }else{
                return;
            }
        }

        for (int[] ints : keyCount) {
            int length=ints.length;
            int cnt=0;
            for (int hokey : ints) {
                for (int dix : combi) {
                    if(hokey==dix){
                        cnt++;
                    }
                }
            }
            
            if(cnt==length){
                return;
            }
        }

        keyCount.add(combi.clone());
      
    }
}