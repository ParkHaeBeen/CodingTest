import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer> list= new HashMap<>();
        list.put(clothes[0][1], 1);

        for (int i=1;i< clothes.length;i++) {

            System.out.println(clothes[i][1]);
            boolean flag=false;
            for (Map.Entry<String, Integer> stringIntegerEntry : list.entrySet()) {
                if(stringIntegerEntry.getKey().equals(clothes[i][1])){
                    stringIntegerEntry.setValue(stringIntegerEntry.getValue()+1);

                    flag=false;
                    break;
                }else{
                    flag=true;
                }
            }

            if(flag){
                list.put(clothes[i][1],1);
            }


        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (Integer value : list.values()) {
            arrayList.add(value);
        }


        for(int i=0;i<arrayList.size();i++){
            int gop=1;
            for(int k=i+1;k<arrayList.size();k++){
                gop*=(arrayList.get(k)+1);
            }
            answer+=arrayList.get(i)*gop;
        }

        return answer;
    }
}