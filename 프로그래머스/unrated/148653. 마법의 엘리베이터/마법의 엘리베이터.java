class Solution {
    static  int result=0;
    public int solution(int storey) {
        find(storey);
        return result;
    }

    private void find(int storey) {
        int length = String.valueOf(storey).length();

        for (int i=0;i<length;i++) {
            int arrnum= (int) Math.pow(10,i+1);
            int num= (storey%arrnum);
            if(num>arrnum/2){
               int count=(arrnum-num);
               result+=count/(arrnum/10);
               storey+=count;
            }else if(num==arrnum/2){
                boolean flag=false;
                if(i!=length-1){
                    int num2=storey%(arrnum*10)/arrnum;
                    if(num2>=5){
                        flag=true;
                    }
                }

                if(flag==false){
                    result+=num/(arrnum/10);
                    storey-=num;
                }else{
                    int count=(arrnum-num);
                    result+=count/(arrnum/10);
                    storey+=count;
                }
            }else{
                result+=num/(arrnum/10);
                storey-=num;
            }
          
        }
         if(storey!=0){
               int num3= (int) Math.pow(10,length);
               result+=storey/num3;
        }
    }
}