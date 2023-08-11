import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1sub = o1.substring(n, n + 1);
                String o2sub=o2.substring(n,n+1);

                if(!o1sub.equals(o2sub)){
                    return o1sub.compareTo(o2sub);
                }
                return o1.compareTo(o2);
            }
        });
        return strings;
    }
}