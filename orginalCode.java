class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int start = 0;
        boolean isNegative = false;

        // Skip leading whitespace
        while (start < n && Character.isWhitespace(s.charAt(start))) {
            start++;
        }

        if (start < n && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
            isNegative = s.charAt(start) == '-';
            start++;
        }

        // Convert digits to integer
        long result = 0;
        for (int i = start; i < n; i++) {
            char temp = s.charAt(i);
            if (temp >= '0' && temp <= '9') {
                result = result * 10 + (temp - '0');
                if (result > Integer.MAX_VALUE) {
                    break;  // Early exit on overflow
                }
            } else {
                break;  // Non-digit character encountered, stop processing
            }
        }

        // Apply sign and handle overflow
        if (isNegative) {
            result = -result;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }
}
