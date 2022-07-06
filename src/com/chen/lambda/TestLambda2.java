package com.chen.lambda;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = null;
/*        // lambda表达式简化
        ILove love = (int a) -> {
            System.out.println("i love you-->"+a);
        };
        // 简化1，去掉参数类型
        love = (a) -> {
            System.out.println("i love you-->"+a);
        };*/
        // 简化2，简化括号
//        love = a -> {System.out.println("i love you-->"+a);};
        // 简化3，去掉花括号
        love = (a,b) -> System.out.println("i love you-->"+a);
        // 总结lambda表达式只能有一行代码的情况下才能简化为一行代码，如果有多行那么就用代码块包裹
        // 前提是接口必须为函数式接口
        // 多个参数也可以去掉参数类型，要去掉就都去了，必须加上括号
        love.love(3,52 );
    }
}

interface ILove{
    void love(int a,int b);
}


