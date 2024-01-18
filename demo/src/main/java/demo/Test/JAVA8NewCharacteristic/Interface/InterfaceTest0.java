package demo.Test.JAVA8NewCharacteristic.Interface;

import org.junit.Test;

public class InterfaceTest0 {



    /**
     *   JDK8之前接口只有  【静态常量 抽象方法】
     *
     *   JDK8之后接口 除了 【静态常量 抽象方法 默认方法 静态方法】
     *
     *  【默认方法 静态方法】区别
     *  1.【默认方法】只能通过实例 去调用 【静态方法】只能通过接口名去调用
     *  2.【默认方法】可以被继承，实现类可以直接调用接口默认方法，也可以重写接口默认方法
     *  3.【静态方法】不能被继承，实现类不能重写接口的静态方法，只能使用接口名调用
     */
    @Test
    public void base0() {

        //默认方法只能通过实例 去调用
        A b = new B();
        b.test3();
        A c = new C();
        c.test3();

        //静态方法只能通过接口名去调用
        A.test4();
    }

    /**
     *  接口中新增抽象方法，所有实现类都需要重写这个方法，不利于接口的扩展
     */
    interface A{
        //静态常量
        static int a = 1;
        //抽象方法
        int test1(int a, int b);
        int test2(int a, int b);
        //默认方法
        public default String test3(){
            System.out.println("hello");
            return  "hello";
        }
        //静态方法
        public static String test4(){
            System.out.println("hello 静态方法只能通过接口类型调用");
            return  "hello4";
        }
    }

    class B implements A{

        @Override
        public int test1(int a, int b) {
            return 0;
        }

        @Override
        public int test2(int a, int b) {
            return 0;
        }


        @Override
        //重写默认方法
        public String test3() {
            System.out.println("b 中实现");
            return "b 中实现";
        }
    }


    class C implements A{

        @Override
        public int test1(int a, int b) {
            return 0;
        }

        @Override
        public int test2(int a, int b) {
            return 0;
        }
    }





  }
