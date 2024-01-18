package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

public class LambdaTest1 {

    @Test
    /**
     * 有参无参
     */
    public void base1() {

        if1 f1 = ()->{ System.out.println(" 无参无返回值");};
        f1.test();
        if2 f2 = (int a)->{ System.out.println(" 单参无返回值a="+a);};
        f2.test(1);
        if3 f3 = (int a,int b)->{ System.out.println(" 多参无返回值a="+a+",b="+b);};
        f3.test(1,2);
        if4 f4 = ()->{System.out.println(" 无参有返回值");return 4;};
        f4.test();
        if5 f5 = (int a)->{System.out.println(" 单参有返回值a="+a+"返回值"+a);return a;};
        f5.test(1);
        if6 f6 = (int a,int b)->{System.out.println(" 多参有返回值a="+a+",b="+b+"返回值"+(a+b));return a+b;};
        f6.test(1,2);
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
