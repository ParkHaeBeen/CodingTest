import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(),"+-",true);

        int sum=0;
        boolean minus=false;
        int pre=0;
        boolean recal=false;
        while(st.hasMoreTokens()){
            String now =st.nextToken();
            boolean number=true;
            if(now.charAt(0)=='-'||now.charAt(0)=='+') number=false;
            if(number){
                if(recal){
                    sum+=pre;
                    int num=pre+Integer.parseInt(now);
                    sum-=num;
                    pre=num;
                    continue;
                }
                if(minus){
                    sum-=Integer.parseInt(now);
                }else{
                    sum+=Integer.parseInt(now);
                }
                pre=Integer.parseInt(now);
            }else{
                if(now.charAt(0)=='-'){
                    if(!minus){
                        recal=false;
                    }
                    minus=true;
                }else{
                    if(minus){
                        recal=true;
                    }
                    minus=false;
                }
            }
        }
        System.out.println(sum);

    }
}
