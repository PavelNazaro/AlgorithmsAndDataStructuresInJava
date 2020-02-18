package Lesson3.Lesson;

public class SimpleMathExpressionParser {

    public static double calc(String expr){
        Stack<String> ops = new Stack<>(100);
        Stack<Double> vals = new Stack<>(100);

        for(String token : expr.split(" ")){
            if (token.equals("(")){
                continue;
            }
            if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/") || token.equals("sqrt")){
                ops.push(token);
            } else if (token.equals(")")){
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")){
                    v = vals.pop() + v;
                } else if (op.equals("-")){
                    v = vals.pop() - v;
                } else if (op.equals("*")){
                    v = vals.pop() * v;
                } else if (op.equals("/")){
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")){
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(token));
            }
        }

        return vals.pop();
    }

    public static void main(String[] args) {
//        String expr = "( 12 + 3 )";
        String expr = "( ( 12 + 3 ) * ( 4 - 1 ) )";
        System.out.printf("Expression %s = %f%n", expr, calc(expr));
//        System.out.printf("Correct result: %f%n", 12.0 + 3.0);
        System.out.printf("Correct result: %f%n", ( 12.0 + 3.0 ) * ( 4.0 - 1.0 ));
    }
}
