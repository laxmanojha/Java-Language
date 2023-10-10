import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExpressionConversion {
    static int prec(char ch) {
        switch(ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder("");
        Stack<Character>ops = new Stack<>();
        for(int i=0;i<infix.length();i++) {
            char ch = infix.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            else if(ch == '(') {
                ops.push(ch);
            }
            else if(ch == ')') {
                while(!ops.isEmpty() && ops.peek() != '(') {
                    postfix.append(ops.pop());
                }
                ops.pop();
            }
            else {
                while(!ops.isEmpty() && prec(ch) <= prec(ops.peek())) {
                    postfix.append(ops.pop());
                }
                ops.push(ch);
            }
        }
        while(!ops.isEmpty()) {
            postfix.append(ops.pop());
        }
        return postfix.toString();
    }
    public static String infixToPrefix(String input) {

        /*reverse the input before changing
                Reverse the infix expression. 
                Note while reversing 
                each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
        */
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        input = sb.toString();
        // converting infix to postfix
        StringBuilder postfix = new StringBuilder("");
        Stack<Character>ops = new Stack<>();
        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            else if(ch == '(') {
                ops.push(ch);
            }
            else if(ch == ')') {
                while(!ops.isEmpty() && ops.peek() != '(') {
                    postfix.append(ops.pop());
                }
                ops.pop();
            }
            else {
                while(!ops.isEmpty() && prec(ch) < prec(ops.peek())) {
                    postfix.append(ops.pop());
                }
                ops.push(ch);
            }
        }
        while(!ops.isEmpty()) {
            postfix.append(ops.pop());
        }

        return postfix.reverse().toString();

    }

    public static String postfixToInfix(String expression) {
        Stack<String>exp = new Stack<>();
        for(int i=0;i<expression.length();i++) {
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                exp.push(ch+"");
            }
            else {
                String val2 = exp.pop();
                String val1 = exp.pop();
                exp.push("("+val1+ch+val2+")");
            }
        }
        return exp.pop();
    }


    public static String prefixToInfix(String expression) {
        Stack<String>exp = new Stack<>();
        for(int i=expression.length()-1;i>=0;i--) {
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                exp.push(ch+"");
            }
            else {
                String val2 = exp.pop();
                String val1 = exp.pop();
                exp.push(val1+ch+val2);    
            }
        }
        StringBuilder sb = new StringBuilder(exp.pop());
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        // String postfix = infixToPostfix("a+b*c/d");
        // System.out.println("Infix to Postfix: "+postfix);
        // System.out.println("Postfix to Infix: "+postfixToInfix(postfix));
        // String prefix = infixToPrefix("a+b*c/d");
        // System.out.println("Infix to prefix: "+prefix);
        // System.out.println("prefix to infix: "+prefixToInfix(prefix));

        Stack<Integer>one = new Stack<>();
        Stack<Integer>two = new Stack<>();
        // StringBuilder sb = new StringBuilder("hello");
        // sb.setCharAt(1,'a');
        // System.out.println(sb.toString());
        // one.push(1);
        // one.push(2);
        // two = one;
        // while(!two.isEmpty()) {
        //     System.out.print(two.pop()+" ");
        // }
        // System.out.println(one.isEmpty()+" "+two.isEmpty());
    }
}