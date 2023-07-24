class Solution {
    public int[] solution(String[] park, String[] routes) {
       int[] answer = new int[2];
        String[][] parkMap=new String[park.length][park[0].length()];
        int height= park.length-1;
        int width=park[0].length()-1;
        int index=0;

        for (String s : park) {
            String[] split = s.split("");
            int index2=0;
            for (String route : split) {
                if(route.equals("S")){
                    answer[0]=index;
                    answer[1]=index2;
                }
                parkMap[index][index2++]=route;
            }
            index++;
        }



        for (String route : routes) {
            int routeNum =route.charAt(2)-'0';
            boolean flag=true;
            if(route.startsWith("E")){
                if(answer[1]+routeNum<=width){

                    for(int i=answer[1]+1;i<=answer[1]+routeNum;i++) {
                        if (parkMap[answer[0]][i].equals("X")){
                            flag=false;
                            break;
                        }
                    }

                    if(flag){
                        answer[1]+=routeNum;
                    }
                }
            }else if(route.startsWith("S")){

                if(answer[0]+routeNum<=height){

                    for(int i=answer[0]+1;i<=answer[0]+routeNum;i++){

                        if(parkMap[i][answer[1]].equals("X")){
                            flag=false;
                            break;
                        }
                    }

                    if(flag==true){
                        answer[0]+=routeNum;
                    }
                }

            } else if (route.startsWith("W")) {
                if(answer[1]-routeNum>=0){

                    for(int i=answer[1]-1;i>=answer[1]-routeNum;i--) {
                        if (parkMap[answer[0]][i].equals("X")){
                            flag=false;
                            break;
                        }
                    }

                    if(flag){
                        answer[1]-=routeNum;
                    }
                }
            }else{
                if(answer[0]-routeNum>=0){

                    for(int i=answer[0]-1;i>=answer[0]-routeNum;i--){
                        if(parkMap[i][answer[1]].equals("X")){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                         answer[0]-=routeNum;
                    }
                }

            }

        }


        return answer;
    }
}