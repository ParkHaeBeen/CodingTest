import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        int cnt=0;
        char[] skills=skill.toCharArray();
        Map<Character,Integer> list;
        for(String tree:skill_trees){
            list=new HashMap<>();
            for(int i=0;i<skills.length;i++){
                list.put(skills[i],tree.indexOf(skills[i]));
            }
            
            boolean flag=true;
            int preidx=0;
            boolean left=false;
            for(int i=0;i<skills.length;i++){
                Integer idx = list.get(skills[i]);
                //System.out.println(skills[i]);
                if(left==false) {
                    if ((preidx == -1 && idx != -1) || idx != -1 && idx < preidx) {
                        //System.out.println(idx+ " "+preidx);
                        flag = false;
                        break;
                    }
                    if (idx == -1) {
                        left = true;
                        continue;
                    }
                    preidx=idx;
                }else {
                    if(idx!=-1){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                //System.out.println(tree);
                cnt++;
            }
        }
        return cnt;
    }
}