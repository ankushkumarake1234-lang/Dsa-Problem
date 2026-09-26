import java.lang.*;
import java.util.*;
class Solution {
    public String removeStars(String s) {
        Stack<Character> ans = new Stack<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                ans.pop();
            }else{
                ans.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : ans){
            result.append(ch);
        }
        return result.toString();
    }
}