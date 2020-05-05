package com.mg.knowledge.design.interpreter;

public class TerminalExpression extends  Expression {
    @Override
    public Object interpreter(Context ctx) {
        return ctx.value;
    }
}
