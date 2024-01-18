package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.function.Consumer;

public class MethodReferenceTest1 {

    /**
     * 方法引用
     */
    @Test
    public void test(){

        /**
         * 方法引用（Method Reference）是用来直接访问类或者实例已经存在的方法或者构造方法。
         * 方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。
         * 计算时，方法引用会创建函数式接口的一个实例。
         * 当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。
         * 作用
         * 1.方法引用的唯一用途是支持Lambda的简写。
         * 2.方法引用提高了代码的可读性，也使逻辑更加清晰。
         * 组成
         * 使用::操作符将方法名和对象或类的名字分隔开。::是域操作符（也可以称作定界符、分隔符）。
         * 可见其基本形式是：方法容器::方法名称或者关键字
         * /
       /* printMax(a->{
            int sum =0;
            for (int i:a) {
                sum+=i;
            }
            System.out.println("数组之和"+sum);
        });*/

        /**
         * 因为在Lambda表达式中要执行的代码和我们另一个方法中的代码是一样的，
         * 这时就没有必要重写一份逻辑了，这时我们就可以“引用“重复代码
         */
        printMax(MethodReferenceTest1::getTotal);




    }

    public static int getTotal(int[] a){
        int sum =0;
        for (int i:a) {
            sum+=i;
        }
        System.out.println("数组之和"+sum);
        return sum;
    }

    private static void printMax(Consumer<int[]> consumer){

        int[] a = {1,2,3,4,5};
        consumer.accept(a);

    }

}
