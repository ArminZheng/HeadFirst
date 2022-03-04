package com.arminzheng.function;

public class FunctionTest {
    public void a(Integer param1, int param2) {
        System.out.println("i1 = " + param1 + param2);
    }

    public static void main(String[] args) {
        // --可以传入[定义的类][Test2]或者[定义的类的父类][Test1]传入进去，向上兼容;
        MyInter m = FunctionTest::a;
        Test2 test2 = new Test2();
        m.d(test2, 1, 3);
        MyInter m2 = (t, p1, p2) -> t.speak(p1, p2);//默认是Test2
        m2.d(test2, 1, 3);
    }
}

class Test2 extends FunctionTest {
    void speak(Integer param1, int param2) {
        System.out.println("i2 = " + (param1 + param2));
    }
}

@FunctionalInterface
interface MyInter {
    // --接口参数比上述的a方法参数数量多一个，即被调用的类[第一个]，其它参数要一致
    // --且Test1::a的Test1是该入参类型Test2的父类，向少的类扩展
    public void d(Test2 d, int param1, int param2);
}