package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

public class LambdaTest0 {


    @Test
    /**
     * 基础
     */
    public void base0() {
        //匿名内部类
        Cal c = new Cal(){

            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        //lambda表达式
        Cal c1 = (int a, int b) -> { return a + b; };
        //        ()参数      ->    {} 方法体

        System.out.println(c.add(1,2));
        System.out.println(c1.add(1,2));
    }

    interface Cal{
        int add(int a, int b);
    }

  }
