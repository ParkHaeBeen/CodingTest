class Solution {
     public long solution(int k, int d) {
        long answer = 0;
    
        for(int i=0;i*k<=d;i++){
            double distance = getDistance(i*k, d);
            answer+=(long)distance/k+1;
        }
        return answer;
    }

    public double getDistance(int x, int d){
        return Math.sqrt(Math.abs(Math.pow(x,2)-Math.pow(d,2)));
    }
}