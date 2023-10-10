import java.util.*;
// Shunting Yard Algorithm by Edger Djikstra
public class ExpressionEval {
    public static int infixEvaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        //space number (  )(precedence)  operands  push(currOp)
        for(int i=0;i<tokens.length;i++) {

            if(tokens[i] == ' ') 
                continue;

            else if(tokens[i]>='0' && tokens[i]<='9') {
                StringBuilder sb = new StringBuilder("");
                while(i<tokens.length && tokens[i]>='0' && tokens[i]<='9') {
                    sb.append(tokens[i++]);
                }
                // values.push(Integer.valueOf(sb.toString()));
                values.push(Integer.parseInt(sb.toString()));

                i--;
            }

            else if(tokens[i] == '(')
                ops.push(tokens[i]);
            
            else if(tokens[i] == ')') {
                while(ops.peek()!='(' ) {
                    values.push(calculate(ops.pop(),values.pop(),values.pop()));
                }
                ops.pop();
            }

            else if(tokens[i]=='+' || tokens[i]=='-' || tokens[i]=='*' || tokens[i]=='/') {
                while(!ops.isEmpty() && hasPrecdency(tokens[i],ops.peek())) {
                    values.push(calculate(ops.pop(),values.pop(),values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while(!ops.isEmpty()) {
            values.push(calculate(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }
    static int calculate(char ops, int b, int a) {
        switch(ops) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
    static boolean hasPrecdency(char op1, char op2) {
        if(op2=='(' || op2==')')
            return false;
        else if((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))
            return false;
        else 
            return true;
    }

    static int postfixEvaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        for(int i=0;i<expression.length();i++) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)) {
                values.push(ch-'0');
            }
            else {
                int val2 = values.pop();
                int val1 = values.pop();
                switch(ch) {
                    case '+': values.push(val1+val2);break;
                    case '-': values.push(val1-val2);break;
                    case '*': values.push(val1*val2);break;
                    case '/': values.push(val1/val2);break;
                }
            }
        }
        return values.pop();
    }
    static int prefixEvaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        for(int i=expression.length()-1;i>=0;i--) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)) {
                values.push(ch-'0');
            }
            else {
                int val1 = values.pop();
                int val2 = values.pop();
                switch(ch) {
                    case '+': values.push(val1+val2);break;
                    case '-': values.push(val1-val2);break;
                    case '*': values.push(val1*val2);break;
                    case '/': values.push(val1/val2);break;
                }
            }
        }
        return values.pop();
    }
    public static void main(String[] args) {
        System.out.println(infixEvaluate("10 + 2 * 6"));
        System.out.println(postfixEvaluate("231*+9-"));
        System.out.println(prefixEvaluate("-9*26"));
        // System.out.println(infixEvaluate("100 * 2 + 12"));
        // System.out.println(infixEvaluate("100 * ( 2 + 12 )"));
        // System.out.println(infixEvaluate("100 * ( 2 + 12 ) / 14"));
    }
}
