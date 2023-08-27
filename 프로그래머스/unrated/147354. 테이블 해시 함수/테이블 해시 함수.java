import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1]>o2[col-1]){
                    return 1;
                }else if(o1[col-1]==o2[col-1]){
                    if(o1[0]>o2[0]){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return -1;
            }
        });
        
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=row_begin-1;i<=row_end-1;i++){
            int sum=0;
            for(int k=0;k<data[i].length;k++){
                int num=data[i][k]%(i+1);
                sum+=num;
            }
            list.add(sum);
        }

        answer=list.get(0);
        for (int i=1;i<list.size();i++) {
            answer=answer^list.get(i);
        }


        return answer;
    }
}