class Solution {
    public int solution(String s) {
        int answer = 0;
        String answers="";
        String[] numbers= new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        int index=0;
        for (String number : numbers) {
            int i = s.indexOf(number);
            if(i!=-1){
                s=s.replaceAll(number,String.valueOf(index));

            }
            index++;

        }
        return Integer.parseInt(s);
    }
}