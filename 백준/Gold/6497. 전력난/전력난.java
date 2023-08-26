import java.io.*;
import java.util.*;
public class Main {
    static int M,N,sum;
    static ArrayList<Light> list;
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(M==0&&N==0){
                break;
            }
            list=new ArrayList<>();
            sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list.add(new Light(start, end, cost));
                sum += cost;
            }
            group = new int[N];
            for (int i = 0; i < N; i++) {
                group[i] = i;
            }
            Collections.sort(list);

            int result = 0;
            for (Light light : list) {
                int group1 = find(light.start);
                int group2 = find(light.end);

                if (group1 != group2) {
                    group[group2] = group1;
                    result += light.cost;
                }
            }

            System.out.println(sum - result);
        }
        br.close();
    }

    private static int find(int start) {
        if(start==group[start]){
            return start;
        }else {
            return group[start]=find(group[start]);
        }
    }
}

class Light implements Comparable<Light>{
    int start,end,cost;

    public Light(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Light o) {
        return this.cost-o.cost;
    }
}
