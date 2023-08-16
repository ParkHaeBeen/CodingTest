import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true) {
             LinkedList<Integer> list = new LinkedList<>();
            int N=Integer.parseInt(br.readLine());
            if(N==-1) break;
            int sum = 0;

            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    
                    if (i != N / i) {
                        if (i == 1) {
                            sum += i;
                            list.add(i);
                            continue;
                        }
                        list.add(i);
                        list.add(N / i);
                        sum += i + N / i;
                    } else {
                        sum += i;
                        list.add(i);
                    }
                }
            }
            Collections.sort(list);

            System.out.print(N+" ");
            StringBuilder sb=new StringBuilder();
            if(sum==N){
                
                sb.append("=");
                for (Integer integer : list) {
                    sb.append(" "+integer+" +");
                }
                sb.delete(sb.length()-2,sb.length());
                System.out.println(sb.toString());
            }else{
                System.out.println("is NOT perfect.");
            }
        }
    }
}