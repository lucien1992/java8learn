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
public class FunctionalInterface_ConsumerTest {

    @Test
    public void base2() {

        //消费型接口 Consumer
        //accept("hello", System.out::println);

        accept2("hello",str->{
            System.out.println("转小写："+str.toLowerCase());
        },str->{
            System.out.println("转大写："+str.toUpperCase());
        });
    }

    /**
     * 消费型接口 Consumer
     * Consumer 接口只有一个抽象方法 accept，参数列表只有一个泛型t，无返回值，重点在于内部消费
     */
    public static <T> void accept(T t, Consumer<T> consumer){
        consumer.accept(t);
    }


    // 组合操作 连续执行两个方法
    public static <T> void accept2(String str,Consumer<String> consumer, Consumer<String> consumer1){

        //consumer.accept(str);//转小写
        //consumer1.accept(str);//转大写

        //先小写 后大写
        //consumer.andThen(consumer1).accept(str);
        //先大写 后小写
        consumer1.andThen(consumer).accept(str);

    }



}
