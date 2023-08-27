import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        LinkedList<Fruit> list=new LinkedList<>();
        Arrays.sort(tangerine);
        for(int i=0;i<tangerine.length;i++){
            int count=1;
            int idx=i+1;
            while(idx<=tangerine.length-1&&tangerine[i]==tangerine[idx]){
                count++;
                idx++;
                if(idx==tangerine.length) break;
            }
            list.add(new Fruit(tangerine[i],count));
            i=idx-1;
        }

        Collections.sort(list);
        int sum=0;
        for (Fruit fruit : list) {
            sum+=fruit.count;
            answer++;
            if(sum>=k){
                break;
            }
        }
        return answer;
    }
}
class Fruit implements Comparable<Fruit>{
    int number,count;

    public Fruit(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Fruit o) {
        return  o.count-this.count;
    }

}