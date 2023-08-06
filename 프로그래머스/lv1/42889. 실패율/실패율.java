import java.util.*;
class Solution {
     public static int[] solution(int N, int[] stages) {
        int[] result=new int[N];
        ArrayDeque<Integer> list=new ArrayDeque<>();
        Arrays.sort(stages);
        for (int stage : stages) {
            list.add(stage);
        }

        List<Game> list2=new ArrayList<>();
        int idx=1;
        while(idx<=N){
            if(idx>N){
                break;
            }
            //System.out.println(list.getFirst());
            if(list.isEmpty()||idx!=list.getFirst()){
                list2.add(new Game(idx,0));
            } else if(idx==list.getFirst()) {
                int all = list.size();
                int stage = list.pollFirst();
                int count = 1;
                while (!list.isEmpty()&&list.getFirst() == stage) {
                    Integer integer = list.pollFirst();
                    count++;

                }
                list2.add(new Game(stage, (double) count / all));

            }
            idx++;
        }

        Collections.sort(list2);


        for (int i=0;i<result.length;i++) {
            result[i]=list2.get(i).getStage();
        }

        return result;
    }
}
class Game implements Comparable<Game>{
    int stage;
    double fail;

    public int getStage() {
        return stage;
    }

    public double getFail() {
        return fail;
    }

    public Game(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    @Override
    public int compareTo(Game o) {
        if (fail > o.fail ) {
            return -1;
        }
        
        if (fail < o.fail ) {
            return 1;
        }
        return Integer.compare(stage, o.stage);
    }
    
}