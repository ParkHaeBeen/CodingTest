import java.io.*;
import java.util.*;

class Main {

    static int M,N,K;
    static boolean[][] maps;
    static int[] dirX=new int[]{1,-1,0,0};
    static int[] dirY=new int[]{0,0,1,-1};
    static String result="NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        
        maps=new boolean[M][N];
        for(int i=0;i<M;i++){
            String ele=br.readLine();
            for(int k=0;k<ele.length();k++){
                if(ele.charAt(k)=='0'){
                    maps[i][k]=true;
                }else{
                    maps[i][k]=false;
                }
            }
        }


        for (int k = 0; k < maps[0].length; k++) {
            if (maps[0][k]) {
                maps[0][k] = false;
                dfs(0, k);
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void dfs(int y, int x) {
        
        if(y==maps.length-1){
            result="YES";
            return;
        }
        
        for(int i=0;i<4;i++){
            int newY=y+dirY[i];
            int newX=x+dirX[i];
            
            if(newX<0||newY<0||newX>=maps[0].length||newY>=maps.length){
                continue;
            }
            if(maps[newY][newX]){
                maps[newY][newX]=false;
                dfs(newY,newX);
            }
        }
    }

}