import java.io.*;
import java.util.*;
public class Main{
    static int[]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String numbers=br.readLine();

        if(numbers.length()<=9){
            char[] charArray = numbers.toCharArray();
            StringBuilder sb=new StringBuilder();
            for (char c : charArray) {
                sb.append(c+" ");
            }
            System.out.println(sb.toString().trim());
        }else{
            int num=(numbers.length()-9)/2;
            int realNum=9+num;
            arr=new int[realNum];
            Set<Integer> number=new HashSet<>();
            getWay(realNum,number,numbers,0,0);
        }

        br.close();
    }

    private static void getWay(int MaxNum, Set<Integer> number, String numbers, int L,int idx) {

        if(L==numbers.length()){
            if(number.size()!=MaxNum){
                return;
            }else{
                StringBuilder sb=new StringBuilder();
                for (int i : arr) {
                    sb.append(i+" ");
                }
                System.out.println(sb.toString().trim());
                System.exit(0);
            }
        }


        if (L < numbers.length() - 1) {
            if (numbers.charAt(L) - '0' == 0) return;
            int num = Integer.parseInt(numbers.substring(L, L+2));

            if (num <= MaxNum && !number.contains(num)) {
                number.add(num);
                arr[idx] = num;
                getWay(MaxNum, number, numbers, L + 2, idx + 1);
                number.remove(num);
            }
        }
        if (!number.contains(numbers.charAt(L) - '0')) {
            number.add(numbers.charAt(L) - '0');
            arr[idx] = numbers.charAt(L) - '0';
            getWay(MaxNum, number, numbers, L + 1, idx + 1);
            number.remove(numbers.charAt(L) - '0');
        }
    }
}
