class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime=Integer.MIN_VALUE;
        int idx=-1;
        String musicname="(None)";
        int nowidx=0;
        for(String musicinfo:musicinfos){
            String[] infos=musicinfo.split(",");
            String[] start=infos[0].split(":");
            String[] end=infos[1].split(":");
            int time=(Integer.parseInt(end[0])*60+Integer.parseInt(end[1]))-(Integer.parseInt(start[0])*60+Integer.parseInt(start[1]));
            StringBuilder musicly=new StringBuilder();
            infos[3]=changeshop(infos[3]);
            
            if(infos[3].length()<time){
                int cnt=time/infos[3].length();
                int left=time%infos[3].length();
                for(int i=0;i<cnt;i++){
                    musicly.append(infos[3]);
                }
                if(left>0){
                    musicly.append(infos[3].substring(0,left));
                }
            }else if(infos[3].length()>time){
                musicly.append(infos[3].substring(0,time));
            }else{
                musicly.append(infos[3]);
            }
            
            m=changeshop(m);
            int musicidx=musicly.toString().indexOf(m);
            if(musicidx!=-1){    
                if(time>maxTime){
                    maxTime=time;
                    idx=nowidx;
                    musicname=infos[2];
                }
            }
            nowidx++;
        }
        
        answer=musicname;
        
        return answer;
    }
    
    String changeshop(String note){
        note=note.replace("C#","c");
        note=note.replace("D#","d");
        note=note.replace("F#","f");
        note= note.replace("G#","g");
        note=note.replace("A#","a");
        return note;
    }
}