import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String[] params = s.split(" ");
        int people=Integer.parseInt(params[0]);
        int k=Integer.parseInt(params[1]);

        LinkedList<Integer> list= new LinkedList<>();
        IntStream.range(1,people+1).forEach(i->list.add(i));
        List<Integer> dap= new ArrayList<>();
        LinkedList<Integer> clone = new LinkedList<>();
        clone.addAll(list);
        int length=clone.size();
        for(int i=0;i<length;i++){
            if(k-1<clone.size()){
                Integer remove = clone.remove(k - 1);
                dap.add(remove);
                for(int h=0;h<k-1;h++){
                    clone.add(clone.poll());
                }

            }else{
                int index=(k-1)%clone.size();
                Integer remove = clone.remove(index);
                dap.add(remove);
                for(int h=0;h<index;h++){
                    clone.add(clone.poll());
                }
            }
        }

        StringJoiner st= new StringJoiner(", ","<",">");
        for (Integer integer : dap) {
            st.add(String.valueOf(integer));
        }
        System.out.println(st.toString());

    }


}