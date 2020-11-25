// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
// https://leetcode.com/problems/basic-calculator-ii/

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st=new Stack<>();
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num=num*10+s.charAt(i)-'0';
            }
            
            if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) || i == s.length()-1){
                if(sign == '+'){
                    st.push(num);
                }
                if(sign == '-'){
                    st.push(-num);
                }
                if(sign == '*'){
                    st.push(st.pop()*num);
                }
                if(sign == '/'){
                    st.push(st.pop()/num);
                }
                sign=s.charAt(i);
                num=0;
            }
        }
        int res=0;
        for(int i:st){
            res+=i;
        }
        return res;
    }
}