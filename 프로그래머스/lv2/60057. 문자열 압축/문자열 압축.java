class Solution {
   public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=s.length()/2+1;i++){
            String arr=s;
            int length=getCheck(i,arr);
            answer=Math.min(answer,length);
        }
        return answer;
    }

    public static int getCheck(int zip,String s){
        int start=0;
        int end=zip;
        int length=0;
        while(end<=s.length()){
            String sub=s.substring(start,end);
            int tmpstart=start;
            int tmpend=end;
            int cnt=0;
            while(true){
                if(s.indexOf(sub,tmpstart)!=tmpstart){
                    break;
                }
                cnt++;
                tmpstart+=zip;
                tmpend+=zip;
            }
            if(cnt!=1){
                length+=String.valueOf(cnt).length()+zip;
            }else{
                length+=zip;
            }
            start=tmpstart;
            end=tmpend;
        }
        if(end>s.length()){
            length+=s.length()-start;
        }

        return length;

    }
}