class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] split = my_string.split("");
        for(int i=0;i<split.length;i++){
            boolean flag=true;
            boolean num = split[i].matches("^[0-9]*$");
            if(num){
                int k=i;
                while(flag){
                    ++k;
                    if(k==my_string.length()){
                        break;
                    }
                    flag=split[k].matches("^[0-9]*$");
                }
                String nums=my_string.substring(i,k);
                i=k;
                answer+=Integer.valueOf(nums);

            }
        }
        return answer;
    }
}