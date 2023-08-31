class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] dicountNumber=new int[want.length];

        int maxIdx=discount.length-10;
        for (int i=0;i<10;i++) {
            for(int k=0;k<want.length;k++){
                if(want[k].equals(discount[i])){
                    dicountNumber[k]++;
                }
            }
        }

        boolean flag=false;
        for (int i=0;i<number.length;i++) {
            if(number[i]!=dicountNumber[i]){
                flag=true;
                break;
            }
        }

        if(!flag){
            answer++;
        }
        int start=0;
        int end=10;
        while(end<discount.length){
            for(int i=0;i<want.length;i++){
                if(want[i].equals(discount[start])){
                    dicountNumber[i]--;
                }

                if(want[i].equals(discount[end])){
                    dicountNumber[i]++;
                }
            }
            boolean check = check(number, dicountNumber);
            if(check){
                answer++;
            }
            start++;
            end++;

        }

        return answer;
    }

    private boolean check(int[] number, int[] dicountNumber) {
        for (int i=0;i<number.length;i++) {
            if(number[i]!=dicountNumber[i]){
                return false;
            }
        }

        return true;
    }
}