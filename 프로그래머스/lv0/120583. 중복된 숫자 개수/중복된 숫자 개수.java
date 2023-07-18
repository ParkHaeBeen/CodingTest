import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
         long count = Arrays.stream(array).filter(i -> i == n).count();
        return (int)count;
    }
}