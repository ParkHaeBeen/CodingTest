class Solution {
    static int[] answer;
    static int zerocnt,onecnt;
    public int[] solution(int[][] arr) {
        answer=new int[2];
        check(0,0,arr.length,arr);
        answer[0]=zerocnt;
        answer[1]=onecnt;
        return answer;
    }
    
    public void check(int y,int x,int length,int [][] arr){
        if(length==0){
            return;
        }
        
        boolean check=checkQueryTree(y,x,length,arr);
        if(!check){
            int mid=length/2;
            check(y,x,mid,arr);
            check(y,x+mid,mid,arr);
            check(y+mid,x,mid,arr);
            check(y+mid,x+mid,mid,arr);
        }
    }
    
    public boolean checkQueryTree(int y,int x, int length,int [][] arr){
        int num=arr[y][x];
        for(int i=y;i<y+length;i++){
            for(int k=x;k<x+length;k++){
                if(num!=arr[i][k]){
                    return false;
                }
            }
        }
        if(num==1){
            onecnt++;
        }else{
            zerocnt++;
        }
        return true;
    }
}