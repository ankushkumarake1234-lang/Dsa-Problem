import java.lang.*;
import java.util.*;
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
             return Integer.MAX_VALUE;
        }
        // int ans = 0;
        // while (dividend >= divisor) {
        //     dividend = dividend - divisor;
        //     ans++;
        // }
        // return ans;

        boolean negative = (dividend < 0) ^ (divisor < 0);
        long x = Math.abs((long) dividend); 
        long y = Math.abs((long) divisor);

        long ans = 0;
        while(x >= y){
         long a = y;
         long multi = 1;
         while(x >= (a << 1)){
            a <<= 1;
            multi <<=1;
         }
         x -= a;
         ans += multi;
        }
        if(negative){
            ans = -ans;
        }
        return (int) ans;
    }
}