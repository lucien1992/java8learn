package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

public class LambdaTest2 {

    @Test
    /**
     * 有参无参
     */
    public void base2() {

        /**
         * 精简
         *1,参数类型可以省略
         *2,假如只有一个参数，()括号可以省略
         *3,如果方法体只有一条语句，{}大括号可以省略
         *4,如果方法体中唯一的语句是return返回语句，那省略大括号的同事return也要省略
         */
        if1 f1 = ()-> System.out.println(" 无参无返回值");
        f1.test();
        if2 f2 =  a-> System.out.println(" 单参无返回值a="+a);;
        f2.test(1);
        if3 f3 = (int a,int b)-> System.out.println(" 多参无返回值a="+a+",b="+b);
        f3.test(1,2);
        if4 f4 = ()-> 4;
        System.out.println(" 无参有返回值");
        f4.test();
        if5 f5 =  a-> a;
        System.out.println(" 单参有返回值"+f5.test(1));
        f5.test(1);
        if6 f6 = (int a,int b)-> a+b;
        f6.test(1,2);
        System.out.println(" 多参有返回值a="+f6.test(1,2));
    }



    interface if1{
        /**
         * 无参无返回值
         */
        void test();
    }
    interface if2{
        /**
         * 单参无返回值
         */
        void test(int a);
    }
    interface if3{
        /**
         * 多参无返回值
         */
        void test(int a,int b);
    }
    interface if4{
        /**
         * 无参有返回值
         */
        int test();
    }
    interface if5{
        /**
         * 单参有返回值
         */
        int test(int a);
    }
    interface if6{
        /**
         * 多参有返回值
         */
        int test(int a,int b);
    }

}
