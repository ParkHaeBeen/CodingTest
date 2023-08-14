import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        LinkedList<Integer> list =new LinkedList<>();
        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            list.add(num);
        }
        int answer=0;
        for (Integer integer : list) {
            if(integer==1) continue;
            int num=(int) Math.sqrt((double)integer);
            boolean flag=false;
            for(int i=2;i<=num;i++){
                if(integer%i==0){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                answer++;
            }

        }

        System.out.println(answer);
        br.close();
    }
}
