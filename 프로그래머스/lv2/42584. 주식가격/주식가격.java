import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<Stock> stocks=new PriorityQueue<>();
        for(int i=0;i<prices.length;i++){
            if(stocks.isEmpty()){
                stocks.add(new Stock(prices[i],i));
            }else{
                while(!stocks.isEmpty()&&stocks.peek().price>prices[i]){
                    Stock now=stocks.poll();
                    answer[now.idx]=i-now.idx;
                }
                stocks.add(new Stock(prices[i],i));
            }
        }
        while(!stocks.isEmpty()){
            Stock now=stocks.poll();
            answer[now.idx]=prices.length-now.idx-1;
        }
        return answer;
    }
}
class Stock implements Comparable<Stock>{
    int price,idx;
    
    public Stock(int price,int idx){
        this.price=price;
        this.idx=idx;
    }
    
    @Override
    public int compareTo(Stock st){
        return st.price-this.price;
    }
    
}