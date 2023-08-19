class Solution {
    Position left=new Position(3,1);
    Position right=new Position(3,3);
    public String solution(int[] numbers, String hand) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<numbers.length;i++){
            int num=numbers[i];
            if(num==0){
                num=11;
            }

            if(num%3==1){
                left=new Position (num/3,1);
                sb.append("L");
            }else if(num%3==0){
                right=new Position(num/3-1,3);
                sb.append("R");
            }else{
                int leftD=left.getDistance(new Position(num/3,2));
                int rightD=right.getDistance(new Position(num/3,2));
                if(leftD<rightD){
                    left=new Position(num/3,2);
                    sb.append("L");
                }else if(leftD>rightD){
                    right=new Position(num/3,2);
                    sb.append("R");
                }else{
                    if(hand.equals("right")){
                        right=new Position(num/3,2);
                        sb.append("R");
                    }else{
                        left=new Position(num/3,2);
                        sb.append("L");
                    }
                }
            }
        }

        return sb.toString();
    }
}

class Position{
    int y,x;
    
    public Position(int y,int x){
        this.y=y;
        this.x=x;
    }
    
    public int getDistance(Position p){
        return Math.abs(p.x-this.x)+Math.abs(p.y-this.y);
    }
}
