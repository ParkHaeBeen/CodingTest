import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        arr=new int[T];
        int idx=0;
        while (T-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int nation=Integer.parseInt(st.nextToken());
            int flight=Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> list=new ArrayList<>();
            for(int i=0;i<=nation;i++){
                list.add(new ArrayList<>());
            }

            for(int i=0;i<flight;i++){
                st=new StringTokenizer(br.readLine());
                int start=Integer.parseInt(st.nextToken());
                int end= Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                list.get(end).add(start);
            }
            answer=-1;
            boolean [] visited=new boolean[nation +1];
            find(1, list,visited);
            arr[idx++]=answer;
        }

        for (int i : arr) {
            System.out.println( i);
        }
        br.close();
    }

    private static void find(int idx, ArrayList<ArrayList<Integer>> list,boolean[] visited) {


        for(int i = idx; i< list.size(); i++) {
            if (visited[i] == false) {
                ArrayList<Integer> arrayList = list.get(i);
                visited[i] = true;
                for (Integer arrive : arrayList) {
                    if (visited[arrive] == false) {
                        find(arrive, list, visited);
                    }
                }

                answer++;
            }
        }
    }
}
