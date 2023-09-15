class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double tilt=h/(double)w;
        for(long i=1;i<=w;i++){
            long starth=(long)Math.ceil(tilt*i);
            answer+=h-starth;
        }
        answer=2*answer;
        return answer;
    }
}