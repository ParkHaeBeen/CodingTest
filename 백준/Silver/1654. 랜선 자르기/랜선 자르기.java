import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int K;
    static long answer;
    static List<Integer> list=new LinkedList<>();
    static boolean flag=false;
    static boolean []visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        Integer max = list.get(list.size() - 1);
        getMaxLength(1,max);
        System.out.println(answer);
    }

    private static void getMaxLength(long start,long end) {
        if(start>end){
            return;
        }

        long mid=(start+end)/2;
        if(mid==0){
            return;
        }

        int count = getCount(mid);
        if (count < K) {
            getMaxLength(start, mid - 1);
        } else if (count > K) {
            answer = Math.max(answer, mid);
            getMaxLength(mid + 1, end);
        } else {
            answer = Math.max(answer, mid);
            getMaxLength(mid + 1, end);
        }


    }

    private static int getCount(long min) {
        int sum=0;
        for (Integer integer : list) {
            sum+=integer/min;
        }
        return sum;
    }
}
