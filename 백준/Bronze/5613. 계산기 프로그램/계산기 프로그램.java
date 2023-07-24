import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] flag=new String[]{"+","-","*","/"};
        Scanner sc=new Scanner(System.in);
        String param=sc.nextLine();
        int answer=0;
        int index=0;
        String opertaion="+";
        while(!param.equals("=")){
            if(index%2==0){
                int num = Integer.parseInt(param);
                if(opertaion.equals("+")){
                    answer+=num;
                } else if (opertaion.equals("-")) {
                    answer-=num;
                }else if(opertaion.equals("*")){
                    answer*=num;
                }else{
                    answer/=num;
                }
            }else{
                opertaion=param;
            }
            param=sc.nextLine();
            index++;
        }
        System.out.println(answer);

    }


}
