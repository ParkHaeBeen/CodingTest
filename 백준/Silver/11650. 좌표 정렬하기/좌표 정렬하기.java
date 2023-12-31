import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Point> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }
        Collections.sort(list);
        for (Point point : list) {
            System.out.println(point.x+" "+point.y);
        }
    }

     static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x==o.x){
                return this.y-o.y;
            }
            return this.x-o.x;
        }
    }
}