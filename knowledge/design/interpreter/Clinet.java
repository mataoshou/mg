package com.mg.knowledge.design.interpreter;

import java.util.Stack;

public class Clinet {

    public static void main(String[] args) {
        Context ctx = new Context();

        Stack<Expression> stack = new Stack();

        for(;;)
        {
            break;
        }

        Expression expression = stack.pop();
        expression.interpreter(ctx);
    }
}
