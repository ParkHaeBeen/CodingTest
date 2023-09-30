import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            File file1 = new File(a);
            File file2 = new File(b);
            return file1.compareTo(file2);
        });
        return files;

    }
    
}
class File implements Comparable<File>{
    String filename;
    
    public File(String name){
        this.filename=name;
    }
    
    @Override
    public int compareTo(File f){
        String[] name1=findNumber(this.filename);
        String[] name2=findNumber(f.filename);
        int nameComparison = name1[0].compareToIgnoreCase(name2[0]);
        if(nameComparison>0){
            return 1;
        }else if(nameComparison<0){
            return -1;
        }else {
            if(Integer.parseInt(name1[1])>Integer.parseInt(name2[1])){
                return 1;
            }else if(Integer.parseInt(name1[1])<Integer.parseInt(name2[1])){
                return -1;
            }else{
                return 0;
            }
        }
    }
    
    String[] findNumber(String s){
            
        int startNumberIdx = -1;
        boolean first = true;
        int endNumberIdx = -1;
        int size = 0;
            
        for(int j = 0; j < s.length(); j++){
            if(Character.isDigit(s.charAt(j))){
                if(first) {
                    startNumberIdx = j;
                    first = false;
                }
                size++;
            }else{
                if(!first) break;
            }
        }
        endNumberIdx = startNumberIdx + size - 1;
            
        String head = s.substring(0, startNumberIdx);
        String number = s.substring(startNumberIdx, endNumberIdx+1);
        String tail = s.substring(endNumberIdx+1);
        
        return new String[]{head,number,tail};
    }
}