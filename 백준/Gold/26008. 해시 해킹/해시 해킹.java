import java.util.*;
public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        sc.nextInt();
        long answer=1L;
        String[] split = first.split(" ");
        int gop=Integer.parseInt(split[1]);
        for(int i=0;i<Integer.parseInt(split[0])-1;i++){
            answer=(answer*gop)%1000000007;
        }
        System.out.println(answer);
    }
}