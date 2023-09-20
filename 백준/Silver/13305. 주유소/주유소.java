import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] way=new int[N-1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            way[i]=Integer.parseInt(st.nextToken());
        }

        int[] pay=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            pay[i]=num;

        }
        int exmin=pay[0];
        int sum=0;
        for(int i=0;i<N-1;i++){
            if(exmin>pay[i]){
                exmin=pay[i];
            }

            sum+=exmin*way[i];
        }
        System.out.println(sum);
        br.close();
    }
}