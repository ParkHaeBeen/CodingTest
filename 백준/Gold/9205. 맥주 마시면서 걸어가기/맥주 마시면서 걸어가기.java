import java.io.*;
import java.util.*;

public class Main{
    static LinkedList<Position> con;
    static String answer="sad";
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while(TC-->0){
            int n=Integer.parseInt(br.readLine());

            StringTokenizer st=new StringTokenizer(br.readLine());
            Position home=new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            con=new LinkedList<>();
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                con.add(new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));

            }

            st=new StringTokenizer(br.readLine());
            Position fesitival=new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));


            Gofestival(home,fesitival);

            System.out.println(answer);
            answer="sad";
        }

        br.close();
    }

    private static void Gofestival(Position home, Position fesitival) {

        ArrayDeque<Position> ad=new ArrayDeque<>();
        ad.add(home);
        visited=new boolean[con.size()+1];
        while(!ad.isEmpty()){
            Position conP = ad.pollFirst();
            int distance = fesitival.getDistance(conP);
            if(distance<=1000){
                answer="happy";
                return;
            }
            for(int i=0;i<con.size();i++){
                if(visited[i]==false&&con.get(i).getDistance(conP)<=1000){
                    ad.add(con.get(i));
                    visited[i]=true;
                }
            }
        }

    }
}

class Position{
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Position con){
        return Math.abs(this.x-con.x)+Math.abs(this.y-con.y);
    }
}
