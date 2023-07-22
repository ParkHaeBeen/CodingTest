class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int mok=chicken;
        int na=0;

        while(mok>=9){
            na=mok%10;
            mok=mok/10;
            answer+=mok;
            mok=mok+na;
            if(mok==9&&na==9){
                break;
            }
        }
        
        return answer;
    }
}