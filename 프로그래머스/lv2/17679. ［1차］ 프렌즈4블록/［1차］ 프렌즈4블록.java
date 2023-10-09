import java.util.*;
class Solution {
    static boolean v[][];
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char copy[][] = new char[m][n];
        for(int i=0; i<m ; i++){
            copy[i] = board[i].toCharArray();
        }

        boolean flag = true;
        int cnt=0;
        while(flag){
            v = new boolean[m][n];
            flag = false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(copy[i][j] == '#') continue;
                    if(check(i,j,copy)){
 
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m,n,copy);
            v = new boolean[m][n];
        }
        return answer;
    }
    public static boolean check(int x, int y, char[][] board){
        char ch = board[x][y];
        if(ch == board[x][y+1] && ch== board[x+1][y] && ch == board[x+1][y+1]){
            return true;
        }
        return false;
    }

    public static int erase(int m,int n,char[][] copy){
        int cnt=0;
        for(int i=0;i<copy.length;i++){
            for(int k=0;k<copy[0].length;k++){
                if(v[i][k]){
                    getRemove(copy,i,k);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void getRemove(char[][] copy,int i,int k){
        char[] remove=copy[i];

        LinkedList<Character> list=new LinkedList<>();
        for(int h=copy.length-1;h>=0;h--){
            if(h!=i){
                list.add(copy[h][k]);
            }
        }

        list.add('#');

        for(int h=0;h<copy.length;h++){
            copy[h][k]=list.get(list.size()-h-1);
        }
        
    }
}