import java.lang.*;
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        // int n = s.length();
        // int m = t.length();
        // HashMap<Character, Integer> map1 = new HashMap<>();
        // HashMap<Character, Integer> map2 = new HashMap<>();
        // if (n < m || m == 0) {
        //     return "";
        // }
        // for(int i = 0; i < m; i++) {
        //     char ch = t.charAt(i);
        //     map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        // }
        // int sp = 0;
        // int ep = 0;
        // int minLen = Integer.MAX_VALUE;
        // int start = 0;
        // while(ep<n){
        //     char temp = s.charAt(ep);
        //     map2.put(temp, map2.getOrDefault(temp, 0) + 1);
        //     while (containsAll(map1, map2)) {
        //         int len = ep - sp + 1;
        //         if (len < minLen) {
        //             minLen = len;
        //             start = sp;
        //         }
        //         char temp2 = s.charAt(sp);
        //         int freq = map2.get(temp2);
        //         if (freq == 1) {
        //             map2.remove(temp2);
        //         } else {
        //             map2.put(temp2, freq - 1);
        //         }

        //         sp++;
        //     }
        //     ep++;
        // }
        // if (minLen == Integer.MAX_VALUE) {
        //     return "";
        // }
        // return s.substring(start, start + minLen);



    // }
    // private boolean containsAll(
    //         HashMap<Character, Integer> map1,
    //         HashMap<Character, Integer> map2) {

    //     for (char ch : map1.keySet()) {
    //         if (map2.getOrDefault(ch, 0) < map1.get(ch)) {
    //             return false;
    //         }
    //     }

    //     return true;



        int n = s.length();
        int m = t.length();

        char[] S = s.toCharArray();
        char[] B = t.toCharArray();

        int cm = 0;
        int[] pmap = new int[128];
        int[] smap = new int[128];

        int sp = 0;
        int ep = 0;
        int ans = n + 1;
        int start = 0;

        if (n < m || m == 0) {
            return "";
        }

        for (char cn : B) {
            pmap[cn]++;
        }

        while (ep < n) {
            if (cm < m) {
                char c = S[ep];
                smap[c]++;
                if (smap[c] <= pmap[c]) {
                    cm++;
                }
                ep++;
            }
            while (cm == m) {
                int len = ep - sp;
                if (len < ans) {
                    ans = len;
                    start = sp;
                }
                char c = S[sp];
                smap[c]--;
                if (smap[c] < pmap[c]) {
                    cm--;
                }
                sp++;
            }
        }
        return ans == n + 1 ? "" : s.substring(start, start + ans);
    }
}