package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用函数式接口
 */
public class FunctionalInterface_FunctionTest {

    @Test
    public void base2() {

        //函数型接口 Function<T, R>
        /*Integer hello2 = apply("11111", (str)->Integer.valueOf(str));
        Class<? extends Integer> aClass = hello2.getClass();
        System.out.println("当前数据类型是"+aClass.getName());*/

        apply2("2222",str->{
            Integer strInt = Integer.valueOf(str);
            Class<? extends Integer> aClass1 = strInt.getClass();
            System.out.println("方法1当前数据类型是"+aClass1.getName());
            return strInt;
        },strInt->{
            String IntStr = strInt.toString();
            Class<? extends String> aClass1 = IntStr.getClass();
            System.out.println("方法2当前数据类型是"+aClass1.getName());
            return IntStr;
        });
    }


    /**
     *  函数型接口 Function<T, R>
     * Function<T, R> 只有一个抽象方法名为 apply，参数列表只有一个参数为T，有返回值，返回值的数据类型为R。
     */
    public static Integer apply(String str, Function<String,Integer> function){
        return  function.apply(str);
    }

    // 组合操作 连续执行两个方法
    public static <T> void apply2(String str,Function<String,Integer> function, Function<Integer,String> function1){

        //function.apply(str);//转小写
        //function1.apply(str);//转大写

        //先小写 后大写
        function.andThen(function1).apply(str);

    }

}
