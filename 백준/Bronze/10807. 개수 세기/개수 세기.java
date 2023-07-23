import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();
        HashMap<Integer,Integer> list= new HashMap<>();

        for(int k=0;k<i;k++){
            int num = sc.nextInt();
            if(list.containsKey(num)){
                list.put(num,list.get(num)+1);
            }else{
                list.put(num,1);
            }
        }

        int find = sc.nextInt();
            Integer count = list.get(find);
        System.out.println(count==null?0:count);
    }

}