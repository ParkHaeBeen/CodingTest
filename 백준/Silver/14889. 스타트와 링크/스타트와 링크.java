import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] power;
    static int[] team;
    static int answer=Integer.MAX_VALUE;
    static LinkedList<Integer> number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        power=new int[N+1][N+1];
        team=new int[N/2];

        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=1;k<=N;k++){
                power[i][k]=Integer.parseInt(st.nextToken());
            }
        }

        getCombi(0,1);
        System.out.println(answer);
        br.close();
    }

    private static void getCombi(int L,int idx) {

        if(L==N/2){
            getPower();
            return;
        }
        for(int i=idx;i<=N;i++){
            team[L]=i;
            getCombi(L+1,i+1);
            if(i==1){
                break;
            }
        }
    }

    private static void getPower() {
        int power1=0;
        number=new LinkedList<>();
        for(int i=1;i<=N;i++){
            number.add(i);
        }

        for(int i=0;i<team.length;i++){
            number.remove((Object)team[i]);
            for(int k=i+1;k<team.length;k++){
                power1+=power[team[i]][team[k]]+power[team[k]][team[i]];
            }
        }

        int power2=0;
        for(int i=0;i<number.size();i++){
            for(int k=i+1;k<number.size();k++){
                power2+=power[number.get(i)][number.get(k)]+power[number.get(k)][number.get(i)];
            }
        }
        answer=Math.min(answer,Math.abs(power2-power1));
    }
}
