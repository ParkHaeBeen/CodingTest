import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list);
        long answer=0;
        int idx=0;
        boolean flag=false;
        for(int i=N-1;i>=0;i--){
            if(i==0){
                answer+=list.get(i);
                break;
            }
            Integer num1 = list.get(i);
            Integer num2 = list.get(i - 1);
            if(num1<0&&num2<0){
                idx=i;
                flag=true;
                break;
            }
            if((num1>=0&&num2>=0)&&num1*num2>num1){
                answer+=num1*num2;
                i--;
            }else if(num1==0&&num2<0&&i%2==1){
                i--;
            }else{
                answer+=num1;
            }
        }

        if(flag) {
            for (int i = 0; i <= idx; i++) {
                if (i == idx) {
                    answer += list.get(i);
                    break;
                }
                Integer num1 = list.get(i);
                Integer num2 = list.get(i + 1);
                answer += num1 * num2;
                i++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
