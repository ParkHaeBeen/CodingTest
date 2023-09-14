import java.util.*;

class Solution {
      static String[] pri = {"*+-","*-+","+-*","+*-","-*+","-+*"};
    static ArrayList<Long> ints=new ArrayList<>();
    static ArrayList<Character> characters=new ArrayList<>();
    public static long solution(String expression) {
        long answer = 0;
        int start=0;
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch=='-'||ch=='*'||ch=='+'){
                ints.add(Long.parseLong(expression.substring(start,i)));
                characters.add(ch);
                start=i+1;
            }else if(i==expression.length()-1){
                ints.add(Long.parseLong(expression.substring(start)));
            }

        }

        long max=Long.MIN_VALUE;
        for (String s : pri) {
            LinkedList<Long> integers=new LinkedList<>(ints);
            LinkedList<Character> ops=new LinkedList<>(characters);
            for (char c : s.toCharArray()) {
                for(int i=0;i<ops.size();){
                    Character ch = ops.get(i);
                    if(ch!=c){
                        i++;
                    }else {
                        long num = 0;
                        if (c == '+') {
                            num = integers.get(i) + integers.get(i + 1);
                            integers.set(i, num);
                        } else if (c == '*') {
                            num = integers.get(i) * integers.get(i + 1);
                            integers.set(i, num);
                        } else {
                            num = integers.get(i) - integers.get(i + 1);
                            integers.set(i, num);
                        }
                        integers.remove(i + 1);
                        ops.remove(i);

                    }
                }
            }
            max=Math.max(max,Math.abs(integers.get(0)));
        }
        return max;
    }
}