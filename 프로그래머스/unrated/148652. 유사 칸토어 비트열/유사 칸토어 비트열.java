class Solution {
    private int getValue(int n, long idx) {
        if (n == 0) {
            return 1;
        }
        long len = (long) Math.pow(5, n);
        long sectionLen = len / 5;
        if (idx > 2 * sectionLen && idx <= 3 * sectionLen) {
            return 0;
        }
        return getValue(n - 1, (idx - 1) % sectionLen + 1);
    }

    public int solution(int n, long l, long r) {
        int count = 0;
        for (long i = l; i <= r; i++) {
            count += getValue(n, i);
        }
        return count;
    }
}