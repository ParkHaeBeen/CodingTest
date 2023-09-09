import java.io.*;
import java.util.*;

public class Main {
   static int N,M;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T=Integer.parseInt(br.readLine());

       while(T-->0){
           N=Integer.parseInt(br.readLine());
           StringTokenizer st = new StringTokenizer(br.readLine());
           Point home=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

           LinkedList<Point> con=new LinkedList<>();
           con.add(home);
           for(int i=0;i<N;i++){
               st = new StringTokenizer(br.readLine());
               con.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
           }

           st = new StringTokenizer(br.readLine());
           Point fes=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

           getPossibleFes(con,home,fes,0);
       }
   }

    private static void getPossibleFes( LinkedList<Point> con, Point home, Point fes, int L) {
       ArrayDeque<Point> conP=new ArrayDeque<>();
       conP.add(home);
       boolean [] visitied=new boolean[con.size()];
       String result="sad";
        while(!conP.isEmpty()){
            Point nextCon = conP.pollFirst();
            int distance = fes.getDistance(nextCon);
            if(distance<=1000){
                result="happy";
                break;
            }

            int idx=0;
            for (Point point : con) {

                if(visitied[idx]==false&&nextCon.getDistance(point)<=1000){
                    conP.add(point);
                    visitied[idx]=true;
                }
                idx++;
            }
        }

        System.out.println(result);

    }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Point p){
        return Math.abs(p.x-x)+Math.abs(p.y-y);
    }
}
