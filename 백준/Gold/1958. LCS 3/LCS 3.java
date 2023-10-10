import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1=br.readLine();
        String str2=br.readLine();
        String str3=br.readLine();

        int[][][] dp=new int[str1.length()+1][str2.length()+1][str3.length()+1];

        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        char[] arr3=str3.toCharArray();
        for(int i=1;i<arr1.length+1;i++){
            for(int k=1;k<arr2.length+1;k++){
                for(int h=1;h<arr3.length+1;h++) {
                    if (arr1[i - 1] == arr2[k - 1]&&arr1[i-1]==arr3[h-1]) {
                        dp[i][k][h] = dp[i - 1][k - 1][h-1] + 1;
                    } else {
                        dp[i][k][h] = Math.max(Math.max(dp[i - 1][k][h], dp[i][k - 1][h]),dp[i][k][h-1]);
                    }
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()][str3.length()]);

    }
}