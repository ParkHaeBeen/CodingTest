class Solution {
    int solution(int[][] land) {

        int[][] landScore=new int[land.length][land[0].length];
           
        for(int i=0;i<land[0].length;i++){
            landScore[0][i]=land[0][i];
        }
        for(int i=0;i<land.length-1;i++){
            for(int k=0;k<land[0].length;k++){
                for(int h=0;h<land[0].length;h++){
                    if(k==h) continue;
                     
                    landScore[i+1][h]=Math.max(landScore[i][k]+land[i+1][h],landScore[i+1][h]);
                    
                }
            }
        }
 
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<landScore[0].length;i++){
            max=Math.max(max,landScore[landScore.length-1][i]);
        }

        return max;
    }
}