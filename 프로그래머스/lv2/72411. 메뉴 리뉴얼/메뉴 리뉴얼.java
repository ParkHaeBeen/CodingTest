import java.util.*;
class Solution {
    static LinkedList<Character> list=new LinkedList<>();
    static int count=1;
    static String[] arrs;
    static List<String> result;
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (String order : orders) {
            for(int i=0;i<order.length();i++){
                if(!list.contains(order.charAt(i))) {
                    list.add(order.charAt(i));
                }
            }
        }
        Collections.sort(list);
        arrs=orders;
        LinkedList<String> answers=new LinkedList<>();
        for (int cnt : course) {
            int[] combi=new int[cnt];
            result=new ArrayList<>();
            count=1;
            getCom(cnt,0,0,combi);
            for (String s : result) {
                answers.add(s);
            }
        }
        answer=new String[answers.size()];
        Collections.sort(answers);
        int index=0;
        for (String s : answers) {
            answer[index++]=s;
        }
        return answer;
    }

    private static void getCom(int cnt, int L, int idx, int[] combi) {
        if(L==cnt){
            StringBuilder sb=new StringBuilder();
            for (int i : combi) {
                sb.append(list.get(i));
            }
            check(sb.toString());
            return;
        }
        for(int i=idx;i<list.size();i++){
            combi[L]=i;
            getCom(cnt,L+1,i+1,combi);
        }

    }

    private static void check(String string) {
        int cnt=0;
        for (String arr : arrs) {
            boolean flag=true;
            for(int i=0;i<string.length();i++){
                if(arr.indexOf(string.charAt(i))==-1){
                    flag=false;
                    break;
                }
            }

            if(flag){
                cnt++;
            }
        }
        if(cnt>count){
            result.clear();
            count=cnt;
            result.add(string);
        }else if(cnt==count&&cnt>1){
            result.add(string);
        }

    }
}