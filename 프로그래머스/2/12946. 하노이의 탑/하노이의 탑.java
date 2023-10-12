import java.util.*;
class Solution {
    static List<int[][]> process=new ArrayList<>();
    public int[][] solution(int n) {
        
        Hanoi(n,1,2,3);
        int idx=0;
        
        int[][] answer = new int[process.size()][2];
        for(int [][] arr:process){
            answer[idx][0]=arr[0][0];
            answer[idx][1]=arr[0][1];
            idx++;
        }
        return answer;
    }
    
    public static void Hanoi(int N, int start, int mid, int to) {
		
		if (N == 1) {
			process.add(new int[][]{{start,to}});
			return;
		}
 

		Hanoi(N - 1, start, to, mid);
    

		process.add(new int[][]{{start,to}});
    

		Hanoi(N - 1, mid, start, to);
 
	}
}