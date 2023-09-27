
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jew> jews = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jews.add(new Jew(M, V));
        }

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jews);
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int jewIdx = 0;

        for (int i = 0; i < K; i++) {
            while (jewIdx < N && jews.get(jewIdx).weight <= bags.get(i)) {
                pq.offer(jews.get(jewIdx++).price);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
        br.close();
    }
}

class Jew implements Comparable<Jew> {
    int weight, price;

    public Jew(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jew o) {
        return this.weight - o.weight;
    }
}