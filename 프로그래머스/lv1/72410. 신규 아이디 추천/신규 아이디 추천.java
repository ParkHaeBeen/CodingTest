import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        LinkedList<Character> ids=new LinkedList<>();
        for (int i=0;i<new_id.length();i++) {
            char c=new_id.charAt(i);
            if(c=='-'||c=='_'||c=='.'||(c>='a'&&c<='z')||Character.isDigit(c)){
                ids.add(c);
            }
        }

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<ids.size();i++) {
            if(!stack.isEmpty()){
                char pop=stack.pop();
                if(!(pop=='.'&&pop== ids.get(i))){
                    stack.add(pop);
                    stack.add(ids.get(i));
                }else {
                    stack.add(pop);
                }
            }else{
                if(ids.get(i)!='.') {
                    stack.add(ids.get(i));
                }
            }
        }


        if(stack.size()>0) {
            if (stack.peek() == '.') {
                stack.pop();
            }
        }else{
            stack.add('a');
        }

        String answer="";
        if(stack.size()>=16){
            int loop=stack.size()-15;
            for(int i=0;i<loop;i++){
                stack.pop();
            }
            while(stack.peek()=='.'){
                stack.pop();
            }
        } else if (stack.size()<=2) {
            int loop=3- stack.size();
            char pop=stack.peek();
            for(int i=0;i<loop;i++){
                stack.add(pop);
            }
        }
        answer = stack.stream().map(String::valueOf).collect(Collectors.joining());
        return answer;
    }
}