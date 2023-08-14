import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] arr=new boolean[2*123457];
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            
            for(int i=N+1;i<=2*N;i++){
                if(arr[i]==false) {
                    for (int k = 2; k <= (int) Math.sqrt(i); k++) {
                        if (i % k == 0) {
                            arr[i] = true;
                        }
                    }
                }
            }
            int cnt=0;
            for(int i=N+1;i<=2*N;i++){
                if(arr[i]==false){
                    cnt++;
                }
            }
            list.add(cnt);
        }

        for (Integer integer : list) {
            System.out.println( integer);
        }
        
        
    }
}
