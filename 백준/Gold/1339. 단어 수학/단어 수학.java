import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Map<Character,Integer> maps=new HashMap<>();
        for(int i=0;i<N;i++){
            String strNum=br.readLine();
            int length=strNum.length()-1;
            for(int k=0;k<strNum.length();k++){
                char alpha=strNum.charAt(k);
                int num= (int) (Math.pow(10,length));
                maps.put(alpha,maps.getOrDefault(alpha,0)+num);
                length--;
            }
        }

        PriorityQueue<Alpha> alphas=new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
            alphas.add(new Alpha(entry.getKey(),entry.getValue()));
        }

        int startNum=9;
        long sum=0;
        while(!alphas.isEmpty()){
            int nowCnt = alphas.poll().cnt;
            sum+=nowCnt*startNum;
            startNum--;
        }
        System.out.println(sum);
        br.close();
    }
}

class Alpha implements Comparable<Alpha>{
    char c;
    int cnt;

    public Alpha(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Alpha o) {
        return o.cnt-this.cnt;
    }
}