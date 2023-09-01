import java.util.*;
class Solution {
    static int answer=Integer.MIN_VALUE;
    static int[] lionInfo,peachInfo,answerlion;
    static ArrayList<int[]> list=new ArrayList<>();
    public static int[] solution(int n, int[] info) {
        int[] answer = {-1};
        lionInfo=new int[info.length];
        peachInfo=info;
        answerlion=new int[info.length];

        int peachScore=0;
        for(int i=0;i<info.length;i++){
            if(info[i]>0){
                peachScore+=10-i;
            }
        }
        getMaxDif(peachScore,0,0,n);

        if (list.isEmpty()) return new int[]{-1};
        Collections.sort(list, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return list.get(0);
    }

    private static void getMaxDif(int peach, int lion, int idx,int arrow) {
        if(idx==lionInfo.length){
            int dif=lion-peach;
            if(dif>0&&answer<dif){
                  answerlion=Arrays.copyOf(lionInfo,lionInfo.length);
                  answer=dif;
                  list.clear();
                  list.add(answerlion.clone());
            }else if(answer==dif){
                list.add(lionInfo.clone());
            }
            return;
        }


        if(arrow>0&&peachInfo[idx]+1<=arrow){
            int needArrow=peachInfo[idx]+1;
            lionInfo[idx]=needArrow;
            if(peachInfo[idx]!=0) {
                getMaxDif(peach - (10 - idx), lion + (10 - idx), idx + 1, arrow - needArrow);
            }else{

                getMaxDif(peach, lion + (10 - idx), idx + 1, arrow - needArrow);
            }
        }
        lionInfo[idx]=0;

        if(peachInfo[idx]!=0){
            if(idx==lionInfo.length-1&&arrow>0){
                lionInfo[idx]=arrow;
            }
            getMaxDif(peach,lion,idx+1,arrow);
            lionInfo[idx] = 0;
        } else {
            getMaxDif(peach, lion, idx + 1, arrow);
        }
    }

}
