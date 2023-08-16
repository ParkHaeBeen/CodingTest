import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int i = find(M, arr);
        System.out.println(i);
        br.close();
    }

    private static int find(int m, int[] arr) {
        int start=0;
        int end=0;
        int sum=arr[0];

        int answer=0;
        while(end<=arr.length-1){

            if(sum<m){
                end++;
                if(end>=arr.length){
                    break;
                }
                sum+=arr[end];
            }else if(sum>m){
                sum-=arr[start];
                start++;
            }else {
                answer++;
                if(end+1>=arr.length){
                    break;
                }
                sum=sum-arr[start]+arr[end+1];
                end++;
                start++;
            }
        }

        return answer;
    }
}
