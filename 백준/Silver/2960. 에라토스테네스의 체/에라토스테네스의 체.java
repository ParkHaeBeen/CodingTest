import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int idx=0;
        int answer=0;
        boolean[] arr=new boolean[N+1];
        Loop:
        for(int i=2;i<=N;i++){
            if(arr[i]==false){
                for(int k=i;k<=N;k=k+i){
                    if(arr[k]==false){
                        arr[k]=true;
                        idx++;
                        if(idx==K){
                            answer=k;
                            break Loop;
                        }
                    }
                }
            }

        }
        System.out.println(answer);
}}