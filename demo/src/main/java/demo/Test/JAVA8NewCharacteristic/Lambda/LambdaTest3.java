package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

public class LambdaTest3 {

    @Test
    /**
     * 有参无参
     */
    public void base2() {

        /**
         * 有时候多个lambda表达式实现函数是一样的话，我们可以封装成通用方法，以便于维护
         * 这时候可以用方法引用实现 :
         * 语法是:对象::方法
         * 假如是static方法，可以直接 类名::方法
         */

        /**
         * 多处使用 f1 f2
         */
        if1 f1 = a -> a-1;
        System.out.println(f1.test(1));
        if1 f2 = a -> a-1;
        System.out.println(f2.test(2));

        /**
         * 通用函数实现
         */
        LambdaTest3 lambdaTest3 = new LambdaTest3();
        if1 f3 = lambdaTest3::testa;
        System.out.println(f3.test(3));

        /**
         * 静态通用函数实现
         */
        if1 f4 = LambdaTest3::testb;
        System.out.println(f3.test(4));
    }

    /**
     * 通用函数实现
     * @param a
     * @return
     */
    public  int testa(int a){
        return a-1;
    }

    /**
     * 静态通用函数实现
     * @param a
     * @return
     */
    public static int testb(int a){
        System.out.println(a-1);
        return a-1;
    }

    interface if1{

        /**
         * 单参有返回值
         */
        int test(int a);
    }


}
