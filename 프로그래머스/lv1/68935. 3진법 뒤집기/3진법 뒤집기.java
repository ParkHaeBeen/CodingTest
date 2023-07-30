class Solution {
    public int solution(int n) {
        int answer = 0;
        String test=Integer.toString(n,3);
        StringBuilder sb=new StringBuilder(test);
        test=sb.reverse().toString();
        answer=Integer.parseInt(test,3);
        return answer;
    }
}