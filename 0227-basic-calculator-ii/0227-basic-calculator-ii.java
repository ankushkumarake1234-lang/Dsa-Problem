import java.util.*;
class Solution {
    public int calculate(String s) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // Number
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                operand.push(num);
                i--;
            }
            // Operator
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                while (!operator.isEmpty() && preq(operator.peek()) >= preq(s.charAt(i))) {
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    char op = operator.pop();
                    int ans = solve(val1, val2, op);
                    operand.push(ans);
                }
                operator.push(s.charAt(i));
            }
        }
        // Process remaining operators
        while (!operator.isEmpty()) {
            int val2 = operand.pop();
            int val1 = operand.pop();
            char op = operator.pop();
            int ans = solve(val1, val2, op);
            operand.push(ans);
        }
        return operand.pop();
    }
    public int preq(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }
        return 1;
    }
    public int solve(int val1, int val2, char op) {
        if (op == '+') {
            return val1 + val2;
        }

        else if (op == '-') {
            return val1 - val2;
        }

        else if (op == '*') {
            return val1 * val2;
        }

        else {
            return val1 / val2;
        }
    }
}