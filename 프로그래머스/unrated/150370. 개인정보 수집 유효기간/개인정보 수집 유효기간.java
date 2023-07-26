import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException{
        LinkedList<Calendar> days= new LinkedList<>();
        SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd");
        for(String pri:privacies){
            Date date = df.parse(pri.substring(0, 10));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            days.add(calendar);

        }

        for(int i=0;i<days.size();i++) {
            for (String term : terms) {
                String[] day = term.split(" ");

                if(privacies[i].endsWith(day[0])){
                    days.get(i).add(Calendar.MONTH,Integer.parseInt(day[1]));
                }
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date today1=sdf.parse(today);

        int index2=1;
        for (Calendar day : days) {
            if(today1.after(day.getTime())||today1.equals(day.getTime())) {
                list.add(index2);
            }
            index2++;
        }

        int[] arr = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return arr;
    }
}