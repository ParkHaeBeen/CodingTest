import java.io.*;
import java.util.*;
public class Main{

    static char[] str1;
    static char[] str2;

    static int[][] dp;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // toCharArray() 는 문자열을 char[] 배열로 반환해주는 메소드다.
        str1 = in.nextLine().toCharArray();
        str2 = in.nextLine().toCharArray();

        dp = new int[str1.length+1][str2.length+1];


        for(int i=1;i<str1.length+1;i++){
            for(int h=1;h<str2.length+1;h++){
                if(str1[i-1]==str2[h-1]){
                    dp[i][h]=dp[i-1][h-1]+1;
                }else{
                    dp[i][h]=Math.max(dp[i-1][h],dp[i][h-1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        String stringLCS = getStringLCS(dp, str1);
        System.out.println(stringLCS);

    }

    private static String  getStringLCS(int[][] dp,char[] chars) {
        int i = str1.length;
        int j = str2.length;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                sb.append(str1[i - 1]);
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }


}
