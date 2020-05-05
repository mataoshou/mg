package com.mg.knowledge.design.strategy;
//策略枚举
public enum  Calculator {

    ADD("+")
    {
        @Override
        public int exec(int a, int b) {
            return a+b;
        }
    },

    SUB("-")
    {
        @Override
        public int exec(int a, int b) {
            return a-b;
        }
    };

    String value="";
    
    private Calculator(String _value)
    {
        this.value = _value;
    }

    public String getValue()
    {
        return this.value;
    }

    public abstract int exec(int a,int b);


    public static void main(String[] args) {
        System.out.println(Calculator.ADD.exec(1,1));
    }
}
