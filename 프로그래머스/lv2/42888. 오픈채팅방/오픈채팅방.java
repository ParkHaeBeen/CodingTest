import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        //Id랑 닉네임 저장
        Map<String,String> nickname=new HashMap<>();
        //아이디기준 나가기들어오기 기록
        ArrayDeque<User> users=new ArrayDeque<>();
        for(String re: record){
            String[] cords=re.split(" ");
            if(cords[0].charAt(0)=='E'){
                nickname.put(cords[1],cords[2]);
                users.add(new User(cords[1],'E'));
            }else if(cords[0].charAt(0)=='L'){
                users.add(new User(cords[1],'L'));
            }else{
                nickname.put(cords[1],cords[2]);
            }
        }

        //기록바탕으로 Id로 닉네임알아내기
        String[] answer = new String[users.size()];
        int idx=0;
        while(!users.isEmpty()){
            User now=users.pollFirst();
            String name=nickname.get(now.Id);
             if(now.act=='E'){
                answer[idx]=name+"님이 들어왔습니다.";
            }else{
                answer[idx]=name+"님이 나갔습니다.";
            }
            idx++;
        }
        return answer;
    }
}
class User{
    String Id;
    char act;
    
    public User(String Id, char act){
        this.Id=Id;
        this.act=act;
    }
}
