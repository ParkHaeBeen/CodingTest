import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
            list.add(num);
        }
        Collections.sort(list);
        int rank=0;
        HashMap<Integer,Integer> maps=new HashMap<>();
        for (Integer integer : list) {
            if(!maps.containsKey(integer)){
                maps.put(integer,rank);
                rank++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i : arr) {
            Integer ranking = maps.get(i);
            sb.append(ranking+" ");
        }
        System.out.println(sb.toString().trim());

    }
}