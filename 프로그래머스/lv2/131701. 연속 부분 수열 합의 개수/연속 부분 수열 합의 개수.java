import java.util.*;
class Solution {
    static Set<Integer> numbers=new HashSet<>();
    static int[] haps;
    public int solution(int[] elements) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int element : elements) {
            list.add(element);
        }
        haps=new int[elements.length];
        
        for(int i=0;i<elements.length;i++){
           getHap(i, list);
        }

        return numbers.size();
    }

    private void getHap(int idx, LinkedList<Integer> list) {
        int length=list.size();
        for(int i=0;i<length;i++){
            haps[i]=haps[i]+list.get((i+idx)%length);
            numbers.add(haps[i]);
        }
    }
}