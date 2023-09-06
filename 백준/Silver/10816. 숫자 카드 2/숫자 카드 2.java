import java.io.*;
import java.util.*;
public class Main{
    static int N,M;
    static List<Integer> sang=new ArrayList<>();
    static List<Integer> cards=new ArrayList<>();
    static int[] cardArray;
    static Map<Integer,Integer> cardCount=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            sang.add(Integer.parseInt(st.nextToken()));
        }

        M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        cardArray=new int[M];
        for(int i=0;i<M;i++){
            int num=Integer.parseInt(st.nextToken());
            cardArray[i]=num;
            cards.add(num);
        }

        Collections.sort(cards);

        for(int i=0;i<N;i++){
            Integer findNum = sang.get(i);
            find(0,N-1,findNum);
        }
        int[] answer=new int[M];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            int find=cardArray[i];
            if(cardCount.containsKey(find)){
                sb.append(cardCount.get(find)+" ");
            }else{
                sb.append("0"+" ");
            }
        }

        System.out.println(sb.toString().trim());
        br.close();
    }

    private static void find(int left,int right,Integer findNum) {

        if(left>right){
            return;
        }
        int mid=(left+right)/2;
        int num=cards.get(mid);
        if(num==findNum){
            cardCount.put(findNum,cardCount.getOrDefault(findNum,0)+1);
        }else if(num>findNum){
            find(left,mid-1,findNum);
        }else{
            find(mid+1,right,findNum);
        }
    }
}
