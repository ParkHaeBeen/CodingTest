import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int sum=Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int idx=n-1;
        int k=0;
        int answer=0;
        while (true) {
            if (k >= idx) {
                break;
            }
            if (arr[k] + arr[idx] > sum) {
                idx--;
            } else if (arr[k] + arr[idx] < sum) {
                k++;
            } else if (arr[k] + arr[idx] == sum) {
                k++;
                idx--;
                answer++;
            }
        }

        System.out.println(answer);

    }
}
