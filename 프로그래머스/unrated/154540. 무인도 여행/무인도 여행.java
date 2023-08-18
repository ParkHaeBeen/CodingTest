import java.util.*;
class Solution {
static boolean[][] visitied;
    static char[][] cmaps;
    static int[] dirX={1,-1,0,0};
    static int[] dirY={0,0,1,-1};
    static int answer=0;
    public static int[] solution(String[] maps) {
        
        visitied=new boolean[maps.length][maps[0].length()];
        
        cmaps=new char[maps.length][maps[0].length()];
        
        int idx=0;
        for (String map : maps) {
            String[] split = map.split("");
            for(int i=0;i<split.length;i++){
                cmaps[idx][i]=split[i].charAt(0);
            }
            idx++;
        }
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < cmaps.length; i++) {
            for(int k=0;k<cmaps[0].length;k++) {
                if (visitied[i][k] == false && cmaps[i][k] != 'X') {
                    dfs(i, k);
                    list.add(answer);
                    answer=0;
                }
            }
        }

        if(list.size()==0){
            return new int[]{-1};
        }
        Collections.sort(list);
        int [] result=new int[list.size()];
        idx=0;

        for (Integer integer : list) {
            result[idx++]=integer;
        }
        return result;
    }

    private static void dfs(int y,int x) {
        if(cmaps[y][x]=='X'){
            return;
        }
        if (cmaps[y][x] != 'X' && visitied[y][x] == false) {
            visitied[y][x] = true;
            answer+=cmaps[y][x]-'0';
            for (int h = 0; h < 4; h++) {
                int newY = y + dirY[h];
                int newX = x + dirX[h];
                if(newX<0||newX>=cmaps[0].length||newY<0||newY>=cmaps.length){
                    continue;
                }
                if (visitied[newY][newX] == false) {
                    dfs(newY, newX);
                }
            }
        }
    }
}