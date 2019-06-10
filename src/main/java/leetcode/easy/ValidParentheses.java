package leetcode.easy;

import java.util.Stack;

/**
 *
 <pre>Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  An input string is valid if:
      Open brackets must be closed by the same type of brackets.
      Open brackets must be closed in the correct order.
  Note that an empty string is also considered valid.
 </pre>

 <pre>
 * Example 1:
    Input: "()"
    Output: true
 </pre>

 <pre>
 * Example 2:
     Input: "()[]{}"
    Output: true
 </pre>

 <pre>
   Example 3:
     Input: "(]"
     Output: false
 </pre>

 <pre>Example 4:
         Input: "([)]"
         Output: false
 </pre>

 <pre>
   Example 5:
          Input: "{[]}"
          Output: true
 </pre>
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(solution("()"));
        System.out.println(solution("()[]{}"));
        System.out.println(solution("(}"));
        System.out.println(solution("([)]"));
        System.out.println(solution("{[]}"));
    }


    /**
     1) Declare a character stack S.
     2) Now traverse the expression string exp.
     a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
     b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack
     and if the popped character is the matching starting bracket then fine else parenthesis are not valid.
     3) After complete traversal, if there is some starting bracket left in stack then “not valid”
     * @param inp
     * @return
     */
    static boolean solution(String inp)
    {
        if(inp.trim().length() == 0)
        {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < inp.length() ; i++)
        {
            char c = inp.charAt(i);
            switch (c)
            {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;

                case ')':
                case '}':
                case ']':
                    if(stack.isEmpty())
                        return false;

                    char popChar = stack.pop();
                    if(!isMatch(c,popChar))
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    static boolean isMatch(char a, char b)
    {
        if (a == '(' && b == ')' || a == ')' && b == '(')
            return true;
        else if (a == '{' && b == '}' || a == '}' && b == '{')
            return true;
        else if (a == '[' && b == ']' || a == ']' && b == '[')
            return true;

        return false;
    }
}
