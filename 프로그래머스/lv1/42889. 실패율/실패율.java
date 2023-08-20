import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int allplayers=stages.length;
        Arrays.sort(stages);
        LinkedList<Stage> list=new LinkedList<>();
        for(int i=0;i<stages.length;i++){
            if(stages[i]>N){
                break;
            }
            int nowStage=1;
            while(i<stages.length-1&&stages[i]==stages[i+1]){
                nowStage++;
                i++;
            }
            list.add(new Stage(stages[i],(double) nowStage/allplayers));

            allplayers-=nowStage;
        }

        Collections.sort(list);

        boolean[] check=new boolean[N+1];
        int idx=0;
        for (Stage stage : list) {
            answer[idx++]=stage.stage;
            check[stage.stage]=true;
        }
        
        for(int i=1;i<check.length;i++){
            if(check[i]==false){
                answer[idx++]=i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{4,4,4,4,4};
        solution(4,arr);
    }
}

class Stage implements Comparable<Stage>{
    int stage;
    double fail;

    public Stage(int stage,double fail){
        this.stage=stage;
        this.fail=fail;
    }

    @Override
    public int compareTo(Stage st){
        if(st.fail-this.fail>0){
            return 1;
        }else if(st.fail==this.fail){
            return this.stage-st.stage;
        }
        return -1;
    }

}