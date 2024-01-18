package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.ArrayList;

public class LambdaTest6 {

    @Test
    /**
     * 实际应用
     */
    public void base2() {



    }

    /**
     * 函数式接口
     *
     * 我们知道使用Lambda表达式的前提是需要有函数式接口，
     * 而Lambda表达式使用时不关心接口名，抽象方法名。只关心抽象方法的参数列表和返回值类型。
     * 因此为了让我们使用Lambda表达式更加的方法，在IDK中提供了大量常用的函数式接口 java.util.function 包里
     *
     * 前面我们会发现Consumer接口，Comparator接口都有@Functionallnterface注解:
     * 这个注解是函数式接口注解，所谓的函数式接口，当然首先是一个接口，然后就是在这个接口里面只能有一个抽象方法。
     * 这种类型的接口也称为SAM接口，即Single Abstract Method interfaces

     * 特点
     * 。接口有且仅有一个抽象方法
     * 。允许定义静态方法
     * 。允许定义默认方法
     * 公允许java.lang.Object中的public方法
     * 。该注解不是必须的，如果一个接口符合"函数式接口"定义，
     * 那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。
     * 如果编写的不是函数式接口，但是加上了@Functionlnterface，那么编译器会报错
     */
    // 正确的函数式接口
    @FunctionalInterface
    public interface TestInterface {

        // 抽象方法
        public void sub();

        // java.lang.Object中的public方法
        public boolean equals(Object var1);

        // 默认方法
        public default void defaultMethod(){}

        // 静态方法
        public static void staticMethod(){}
    }

    // 错误的函数式接口(有多个抽象方法)
    @FunctionalInterface
    public interface TestInterface2 {

        void add();
        //void add1();

    }


}
