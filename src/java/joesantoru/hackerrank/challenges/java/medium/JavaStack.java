package joesantoru.hackerrank.challenges.java.medium;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-stack
 */
public class JavaStack {
    public static void main(String []argh)
    {
        JavaStack solution = new JavaStack();

        Scanner sc = new Scanner(System.in);

        // for each line
        while (sc.hasNext()) {
            System.out.println( solution.processLine(sc.next()) );
        }
    }

    private boolean processLine(String line) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = line.toCharArray();
        for(char theChar : chars) {
            boolean result = processChar(stack, theChar);
            if(!result) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean processChar(Stack stack, char theChar) {
        // open, just add to the stack
        if( '(' == theChar || '{' == theChar || '[' == theChar) {
            stack.push(theChar);
        }
        // close, see if we can pop it off
        else if ( ')' == theChar || '}' == theChar || ']' == theChar) {
            if( !stack.isEmpty() ) {
                //check to see whats at the top
                char top = (Character) stack.peek();

                // handle parens
                if( '(' == top && ')' == theChar) {
                    stack.pop();
                }
                // handle brackets
                else if( '{' == top && '}' == theChar) {
                    stack.pop();
                }
                // handle braces
                else if( '[' == top && ']' == theChar) {
                    stack.pop();
                }
                else {
                    return false; // bad scenario
                }
            }
            // the stack is empty and we got a close, bad scenario
            else {
                return false;
            }
        }
        return true;
    }
}
