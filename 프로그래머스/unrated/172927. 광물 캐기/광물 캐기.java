import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        LinkedList<Stone> list = new LinkedList<>();
        int di=0;
        int ir=0;
        int st=0;
        for(int i=0;i<minerals.length;i++){
            if(i%5==0&&i!=0){
                list.add(new Stone(di,ir,st));
                di=0;
                ir=0;
                st=0;
            }

            if(minerals[i].startsWith("d")){
                di++;
            }else if(minerals[i].startsWith("i")){
                ir++;
            }else{
                st++;
            }

            if(i==minerals.length-1){
                list.add(new Stone(di,ir,st));
            }

        }
        
        int allpick= Arrays.stream(picks).sum();
        int needGog=(int)Math.ceil((double) minerals.length/5);
        if(allpick<needGog){
            for(int i=0;i<needGog-allpick;i++){
                list.removeLast();
            }
        }

        Collections.sort(list);

        int idx=0;
        Loop:
        for(int i=0;i<picks.length;i++){
            if(picks[i]!=0){
                int num=picks[i];
                for(int k=0;k<num;k++) {
                    Stone stone = list.get(idx);
                    int tired = find(i, stone);
                    answer+=tired;
                    idx++;
                    if(idx==list.size()){
                        break Loop;
                    }
                }
            }


        }
        return answer;
    }

    private static int find(int i, Stone stone) {
        if(i==0){
            return stone.d+stone.i+stone.s;
        }else if(i==1){
            return stone.d*5+ stone.i+ stone.s;
        }
        return stone.d*25+ stone.i*5+stone.s;
    }
}
class Stone implements Comparable<Stone>{
    int d,i,s;
    
    public Stone(int d, int i, int s){
        this.d=d;
        this.i=i;
        this.s=s;
    }
    
    @Override
    public int compareTo(Stone s){
        if(s.d==this.d){
            if(s.i==this.i){
                return s.s-this.s;
            }
            return s.i-this.i;
            
        }
        return s.d-this.d;
    }
}