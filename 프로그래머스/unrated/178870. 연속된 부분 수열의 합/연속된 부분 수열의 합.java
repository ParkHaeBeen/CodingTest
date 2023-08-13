class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;

        while (start < sequence.length) {
            if (sum < k) {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                } else {
                    break;
                }
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {  // sum == k
                if (min > end - start) {
                    min = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}