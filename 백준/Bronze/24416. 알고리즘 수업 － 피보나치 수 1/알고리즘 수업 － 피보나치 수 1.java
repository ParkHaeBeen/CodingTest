import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        arr[1]=1;
        arr[2]=1;

        int pibo = getPibo(arr, N);
        System.out.println(pibo+" "+(cnt-1));

    }

    private static int getPibo(int[] arr, int n) {
        if(n==1||n==2){
            cnt++;
            return 1;
        }else if(arr[n]!=0){
            cnt++;
            return arr[n];
        }

        arr[n]=getPibo(arr,n-1)+getPibo(arr,n-2);
        return arr[n];
    }
}