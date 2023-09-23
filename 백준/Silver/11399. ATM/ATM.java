import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        List<Integer> times=new ArrayList<>();
        for(int i=0;i<N;i++){
            times.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(times);

        int sum=0;
        int answer=0;
        for(int i=0;i<times.size();i++){
            sum=sum+times.get(i);
            answer+=sum;
        }

        System.out.println(answer);
        br.close();
    }
}