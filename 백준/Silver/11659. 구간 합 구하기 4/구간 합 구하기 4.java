import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int [] arr=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
        }
        result=new int[N+1];
        findHap(arr);
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            int sum=find(start,end);
            list.add(sum);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static void findHap(int[] arr) {
        result[0]=1;
        for(int i=1;i<=arr.length-1;i++){
            result[i]=result[i-1]+arr[i];
        }
    }

    private static int find(int start, int end) {
        return result[end]-result[start-1];
    }
}