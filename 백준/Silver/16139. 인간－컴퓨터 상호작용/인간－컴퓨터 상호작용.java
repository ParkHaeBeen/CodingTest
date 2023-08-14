import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static HashMap<Character,int[]> map=new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();
        int q=Integer.parseInt(br.readLine());


        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<q;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char  ap=st.nextToken().charAt(0);

            if(!map.containsKey(ap)) {
                find(ap, S);
            }
            int[] arrresult = map.get(ap);
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            if(start==0&&arrresult[0]>0){
                list.add(arrresult[end]);
                continue;
            }
            int result=arrresult[end]-arrresult[Math.max(start-1,0)];
            list.add(result);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static void find(char ap,String S) {
        arr=new int[S.length()];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==ap){
                arr[i]=arr[Math.max(i-1,0)]+1;
            }else{
                arr[i]=arr[Math.max(i-1,0)];
            }
        }
        map.put(ap,arr);
    }
}
