import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list=new ArrayList<>();
        for(int k=0;k<i;k++){
            list.add(sc.nextLine());
        }


        ArrayDeque<String> param=new ArrayDeque<>();
        for (String s1 : list) {
            String answer="YES";
            for(String s2:s1.split("")){
                if(s2.equals("(")){
                    param.add("(");
                }else {
                    if(param.isEmpty()){
                        answer="NO";
                        break;
                    }else{
                        String s11 = param.removeLast();
                    }
                }

            }
            if(!param.isEmpty()){
                answer="NO";
            }
            param=new ArrayDeque<>();
            System.out.println(answer);
        }

    }
}