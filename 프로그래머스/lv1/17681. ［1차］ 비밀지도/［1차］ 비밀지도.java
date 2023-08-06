class Solution {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String arr1Bi = Integer.toBinaryString(arr1[i]);
            String arr2Bi = Integer.toBinaryString(arr2[i]);

            arr1Bi=checkLength(arr1Bi,n);
            arr2Bi=checkLength(arr2Bi,n);
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<n;k++){
                char c1 = arr1Bi.charAt(k);
                char c2 = arr2Bi.charAt(k);
                if(c1=='1'||c2=='1'){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i]=sb.toString();
        }
        return answer;
    }

    private static String checkLength(String binary, int n) {
        if(binary.length()<n){
            String zero="";
            for(int i=0;i<n-binary.length();i++) {
                zero+="0";
            }
            return zero+binary;
        }

        return binary;
    }
}