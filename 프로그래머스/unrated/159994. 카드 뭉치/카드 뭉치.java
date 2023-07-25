class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardOne=-1;
        int cardTwo=-1;
        for(String goalOne:goal){
            System.out.println("goalOne = " + goalOne);
            for(int i=0;i<cards1.length;i++){
                if(goalOne.equals(cards1[i])){
                    System.out.println("cardOne = " + cardOne);
                    if(i==cardOne+1){
                        cardOne=i;
                        continue;
                    }else{
                        return "No";
                    }
                }
            }

            for(int i=0;i<cards2.length;i++){
                if(goalOne.equals(cards2[i])){
                    if(i==cardTwo+1){
                        cardTwo=i;
                    }else{
                        return "No";
                    }

                }
            }

        }
        return "Yes";
     }

       
}
