import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int[] ball : balls) {
            if(ball[1]==startY){
                double diff= Math.abs(ball[0]-startX)/2.0;
                double mx=diff*diff;

                int result=0;
                if(startY>=n/2){
                    double num1=(n-startY)*(n-startY)+mx;
                   result=(int)(num1*4);
                }else{
                    double num1=(startY-0)*(startY-0)+mx;
                    result=(int)(num1*4);
                }

                int legnth=startX>ball[0]?2*m-(startX+ball[0]):startX+ball[0];
                int sqrtlength=legnth*legnth;
                if(result>sqrtlength){
                    result=sqrtlength;
                }
                list.add(result);
            }else if(ball[0]==startX){
                double diff= Math.abs(ball[1]-startY)/2.0;
                double mx=diff*diff;

                int result=0;
                if(startX>=m/2){
                    double num1=(m-startX)*(m-startX)+mx;
                    result=(int)(num1*4);

                }else{
                    double num1=(startX-0)*(startX-0)+mx;
                    result=(int)(num1*4);
                }

                int length=startY>ball[1]?2*n-(startY+ball[1]):startY+ball[1];
                int sqrtlength=length*length;


                if(result> sqrtlength){
                    result= sqrtlength;
                }

                list.add(result);
            }else{
                int [][] arr2=new int[][]{
                        {-ball[0],ball[1]},
                        {ball[0],-ball[1]},
                        {ball[0],(n-ball[1])+n},
                        {(m-ball[0])+m,ball[1]}
                };

                int min=Integer.MAX_VALUE;

                for (int[] ints : arr2) {
                    int result=(startX-ints[0])*(startX-ints[0])+(startY-ints[1])*(startY-ints[1]);
                    if(min>result){
                        min=result;
                    }
                }

                list.add(min);
            }
        }
        

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}