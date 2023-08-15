
import java.util.LinkedList;
class Solution {
    static int[] X={0,0,1,-1};
    static int[] Y={1,-1,0,0};
    public static int solution(String[] board) {
        int answer = Integer.MAX_VALUE ;

        int[] RLo = new int[2];
        for(int i=0;i<board.length;i++){
            for(int k=0;k<board[0].length();k++){
                if (board[i].charAt(k) == 'R') {
                    RLo= new int[]{i, k};

                }
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[RLo[0]][RLo[1]] = true;

        LinkedList<Node> list =new LinkedList<>();
        list.add(new Node(RLo[1],RLo[0],0));

        while(!list.isEmpty()){
            Node poll = list.poll();

            int y= poll.y;
            int x= poll.x;

            if (board[y].charAt(x) == 'G') {

                answer=Math.min(answer, poll.count);
            }

            for(int i=0;i<4;i++){
                int newX=x+X[i];
                int newY=y+Y[i];

                if(newX<0||newY<0||newY>=board.length||newX>=board[0].length()){
                    continue;
                }

                if (board[newY].charAt(newX) == 'D') {
                    continue;
                }

                while(newX >= 0 && newY >= 0
                        && newY < board.length && newX < board[0].length()
                        && board[newY].charAt( newX ) != 'D') {
                    newX += X[i];
                    newY += Y[i];
                }

                newX-=X[i];
                newY-=Y[i];

                if (visited[newY][newX]) {
                    continue;
                }
                visited[newY][newX] = true;

                list.offer(new Node(newX, newY, poll.count + 1));
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        String []aa=new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        solution(aa);
    }
}
class Node{
    int x,y,count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
