import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=1;k<=N;k++){
                int check=Integer.parseInt(st.nextToken());
                if(i!=k&&check==1){
                    arr[i][k]=1;
                }
            }
        }

        findPlusWay();

        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                System.out.print(arr[i][k]+" ");
            }
            System.out.println();
        }
    }

    private static void findPlusWay() {

        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                for(int j=1;j<=N;j++){
                    if(arr[k][i]!=0&&arr[i][j]!=0){
                        arr[k][j]=1;
                    }
                }
            }
        }
    }
}
