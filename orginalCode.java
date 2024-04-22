class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        // 通过 start 变量来跳过前面的空格
        int start = 0; 
        boolean isNegative = false;
        StringBuffer sb = new StringBuffer();

        // Skip leading whitespace
        while (start < n &&  s.charAt(start) == ' ') {
            start++;
        }

        // 判断结果符号
        if (start < n && (s.charAt(start) == '+' || s.charAt(start) == '-')) {
            isNegative = s.charAt(start) == '-';
            start++;
        }

        long result = 0;
        for (int i = 0;i < start;i++) {
            char temp = s.charAt(i); 
           // if (temp == '-') {isNegtive = true; }
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

        return (int)result;
    }
}
