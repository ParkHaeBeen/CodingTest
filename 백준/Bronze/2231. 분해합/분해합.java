import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        boolean flag=false;
        for(int i=1;i<=N;i++){
            String num = String.valueOf(i);
            int sum=0;
            char[] nums = num.toCharArray();
            for (char c : nums) {
                sum+=c-'0';
            }
            sum+=i;
            if(sum==N){
                flag=true;
                System.out.println(i);
                break;
            }
        }

        if(!flag){
            System.out.println(0);
        }
        br.close();
    }
}
