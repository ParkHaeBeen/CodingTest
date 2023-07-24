class Solution {
    public int[] solution(String[] wallpaper) {
                int[] answer = new int[4];
        int indexYY=0;
        Integer minYY=null;
        Integer maxYY=null;
        Integer minXX=Integer.MAX_VALUE;;
        Integer maxXX=null;
        for (String s : wallpaper) {
            if(s.contains("#")){
                String[] split = s.split("");
                int indexXX=0;
                for (String s1 : split) {
                    if(s1.equals("#")){
                        if(minYY==null){
                            minYY=indexYY;
                        }
                        if(indexXX<minXX){
                            minXX=indexXX;
                        }
                        if(maxXX==null||maxXX<indexXX+1){
                            maxXX=indexXX+1;
                        }
                        maxYY=indexYY+1;

                    }
                    indexXX++;
                }
            }
            indexYY++;
        }

        answer[0]=minYY;
        answer[1]=minXX;
        answer[2]=maxYY;
        answer[3]=maxXX;

        return answer;
    }
}