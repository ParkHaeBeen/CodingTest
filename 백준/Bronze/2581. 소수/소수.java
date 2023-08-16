import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int M=Integer.parseInt(br.readLine());
        int N=Integer.parseInt(br.readLine());
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int k=M;k<=N;k++){
            if(k==1) continue;
            boolean flag=false;
            for(int i=2;i<=Math.sqrt(k);i++){
                if(k%i==0){

                    flag=true;
                    break;
                }
            }
            if(flag==false){
                if(min>k){
                    min=k;
                }
                sum+=k;
            }
        }

        if(sum==0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }

        br.close();
    }
}