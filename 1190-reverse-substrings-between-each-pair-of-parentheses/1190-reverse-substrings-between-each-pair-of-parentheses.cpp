class Solution {
public:
    string reverseParentheses(string s) {
        stack <int> stack;
        string ans;
        
        for(const char ch : s){
            if(ch == '('){
                stack.push(ans.length());
            }
            else if(ch == ')'){
                const int j = stack.top();
                stack.pop();
                reverse(ans.begin()+j, ans.end());
            }
            else{
                ans += ch;
            }
        }
        return ans;
    }
};