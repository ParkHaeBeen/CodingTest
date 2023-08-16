import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        LinkedList<Integer> list =new LinkedList<>();
        list.add(N);
        LinkedList<Integer> answer=new LinkedList<>();
        while(!list.isEmpty()){
            int length=list.size();
            for(int i=0;i<length;i++) {
                Integer num = list.poll();

                int[] nums = getNums(num);

                boolean check = check(nums[0]);
                boolean check1 = check(nums[1]);
                if(check){
                    if(nums[0]!=1) {
                        answer.add(nums[0]);
                    }
                }else{
                     list.add(nums[0]);
                }

                if(check1){
                    if(nums[1]!=1) {
                        answer.add(nums[1]);
                    }
                }else{
                     list.add(nums[1]);
                }
            }
        }

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println( integer);
        }
        
    }

    private static boolean check(int num) {

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private static int[] getNums(Integer num) {
        int[] arr=new int[2];
        for(int i = (int) Math.sqrt(num); i>0; i--){
            if(num%i==0){
                arr[0]=i;
                arr[1]=num/i;
                break;
            }
        }
        return arr;
    }
}