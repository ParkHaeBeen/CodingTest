import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //유저아이디가 신고한 아이디 리스트
        Map<String,Set<String>> list =new HashMap<>();
        for(String id:id_list) {
            list.put(id,new HashSet<>());
        }

        //신고한아이디가 몇번신고되었는지
        Map<String,Integer> number=new HashMap<>();
        for (String ids : report) {
            StringTokenizer st= new StringTokenizer(ids);
            String user_id=st.nextToken();
            String report_id=st.nextToken();

            if(!list.get(user_id).contains(report_id)){
                list.get(user_id).add(report_id);
                if(number.containsKey(report_id)){
                    number.put(report_id,number.get(report_id)+1);
                }else{
                    number.put(report_id,1);
                }
            }
        }

        LinkedList<String> emaillist=new LinkedList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : number.entrySet()) {
            if(stringIntegerEntry.getValue()>=k){
                emaillist.add(stringIntegerEntry.getKey());
            }
        }

        int index=0;
        for (String s : id_list) {
            for (String emailReport : emaillist) {
                 if(list.get(s).contains(emailReport)){
                     answer[index]=answer[index]+1;
                 }
            }

            index++;
        }


        return answer;
    }
}