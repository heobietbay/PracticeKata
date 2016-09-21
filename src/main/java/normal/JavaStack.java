package normal;
import java.util.*;

/**
 * Created by khoa on 9/21/2016.
 */
public class JavaStack {
    /*
    In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements,
    with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)

    A string containing only parentheses is balanced if the following is true:
    1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

    Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

    Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

    Given a string, determine if it is balanced or not.

    Input Format

        There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

        The part of the code that handles input operation is already provided in the editor.

    Output Format

        For each case, print 'true' if the string is balanced, 'false' otherwise.

    Sample Input

        {}()
        ({()})
        {}(
        []

    Sample Output

        true
        true
        false
        true
    */

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
    static boolean isValid(String inp)
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
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            boolean isValid = isValid(input);

            System.out.println(isValid ? true : false);
        }

    }
}
