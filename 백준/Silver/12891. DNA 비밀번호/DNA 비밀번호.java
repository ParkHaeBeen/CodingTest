import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int S=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());

        int[] count=new int[4];

        String dna=br.readLine();
        st=new StringTokenizer(br.readLine());

        int[]check=new int[4];
        for(int i=0;i<4;i++){
            check[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<P;i++){
            char c = dna.charAt(i);
            if(c=='A'){
                count[0]++;
            }else if(c=='C'){
                count[1]++;
            } else if (c == 'G') {
                count[2]++;
            }else{
                count[3]++;
            }
        }

        int start=0;
        int end=P-1;
        int answer=0;
        while(true){
            if(count[0]>=check[0]&&count[1]>=check[1]&&count[2]>=check[2]&&count[3]>=check[3]){
                answer++;
            }
            if(end==dna.length()-1){
                break;
            }

            char c = dna.charAt(start++);
            changeCount(c,count,'s');
            char c1 = dna.charAt(++end);
            changeCount(c1,count,'e');
        }
        System.out.println(answer);

        br.close();
    }

    private static void changeCount(char c, int[] count,char lo) {
        if(lo=='s') {
            if (c == 'A') {
                count[0]--;
            } else if (c == 'C') {
                count[1]--;
            } else if (c == 'G') {
                count[2]--;
            } else {
                count[3]--;
            }
        }else{
            if (c == 'A') {
                count[0]++;
            } else if (c == 'C') {
                count[1]++;
            } else if (c == 'G') {
                count[2]++;
            } else {
                count[3]++;
            }
        }
    }
}
