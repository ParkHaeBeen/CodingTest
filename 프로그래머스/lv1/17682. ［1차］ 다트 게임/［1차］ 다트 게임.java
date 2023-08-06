class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int now=0;
        int pre=0;

        char[] array = dartResult.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]-'0'>=0&&array[i]-'0'<=10){
                answer+=pre;
                pre=now;
                int num=array[i]-'0';
                if(num==1&&array[i+1]=='0'){
                    num=10;
                    i++;
                }
                if(array[i+1]=='S'){
                    now=num;
                }else if (array[i+1]=='D') {
                    now= (int) Math.pow(num,2);
                }else if(array[i+1]=='T'){
                    now= (int) Math.pow(num,3);
                }
                System.out.println("pre = " + pre);
                System.out.println("now = " + now);
                i++;
            } else if (array[i]=='*') {
                pre*=2;
                now*=2;
            } else if (array[i]=='#') {
                now*=-1;
            }
        }
        answer+=pre+now;
        System.out.println("answer = " + answer);
        return answer;
    }
}