import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        for(int i=N;i<=M;i++){
            if(i==1){
                continue;
            }
            boolean flag=false;
            for(int k=2;k<=Math.sqrt(i);k++){
                if(i%k==0){
                    flag=true;
                    break;
                }
            }

            if(flag==false){
                System.out.println(i);
            }

        }
    }
}
