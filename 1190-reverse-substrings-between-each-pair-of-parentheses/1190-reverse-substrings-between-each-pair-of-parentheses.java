class Solution {
    private void reverse(StringBuilder sb, int start, int end) {
        end--; // Adjust because end index is exclusive in substrings
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ans.length());
            } else if (ch == ')') {
                int j = stack.pop();
                reverse(ans, j, ans.length());
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();  
    }
}