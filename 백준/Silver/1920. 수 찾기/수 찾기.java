import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        list=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            int num=Integer.parseInt(st.nextToken());
            boolean b = find(0, N-1, num);
            if(b==true){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean find(int left,int right,int num) {
        if(left>right){
            return false;
        }
        int mid=(left+right)/2;
        int midNum=list.get(mid);

        if(midNum==num){
            return true;
        }else if(midNum<num){
            return find(mid+1,right,num);
        }else {
            return find(left, mid-1, num);
        }
    }
}