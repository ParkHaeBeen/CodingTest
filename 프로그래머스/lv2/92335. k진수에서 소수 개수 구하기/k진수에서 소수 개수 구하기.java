class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number=Integer.toString(n,k);
        
        if (!number.contains("0")) {
            long num = Long.parseLong(number);
            if (isPrime(num)) {
                return 1;
            } else {
                return 0;
            }
        }

        String[] splitNumbers = number.split("0");
        for (String numStr : splitNumbers) {
            if (numStr.length() > 0 && !numStr.contains("0")) { 
                long num = Long.parseLong(numStr);
                if (isPrime(num)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    
    public boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}