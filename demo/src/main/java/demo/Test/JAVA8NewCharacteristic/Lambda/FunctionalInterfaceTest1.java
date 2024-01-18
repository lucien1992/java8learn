package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * 常用函数式接口
 */
public class FunctionalInterfaceTest1 {

    @Test
    public void base2() {
        //供给型接口 Supplier
        List<Integer> list = supply(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out::println);

        //消费型接口 Consumer
        accept("hello", System.out::println);

        //函数型接口 Function<T, R>
        String hello2 = apply("hello2", String::toUpperCase);
        accept(hello2,System.out::println);

        //断言型接口 Predicate
        List<String> strings = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> strings1 = filter(strings, f -> f.length() == 2);
        System.out.println(strings1);
    }

    /**
     * 常用函数式接口
     */

    /**
     * 供给型接口 Supplier
     * Supplier只有一个抽象方法 get，参数列表为空，有返回值，返回值得数据类型为T
     */
    public static List<Integer> supply(Integer num,Supplier<Integer> supplier){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add(supplier.get());
        }
        return arrayList;
    }
    /**
     * 消费型接口 Consumer
     * Consumer 接口只有一个抽象方法 accept，参数列表只有一个泛型t，无返回值，重点在于内部消费
     */
    public static <T> void accept(T t,Consumer<T> consumer){
        consumer.accept(t);
    }
    /**
     *  函数型接口 Function<T, R>
     * Function<T, R> 只有一个抽象方法名为 apply，参数列表只有一个参数为T，有返回值，返回值的数据类型为R。
     */
    public static String apply(String str,Function<String,String> function){
        return  function.apply(str);
    }
    /**
     *  断言型接口 Predicate
     * 断言型又名判断型。 Predicate 只有一个抽象方法 test，参数列表只有一个参数为 T，有返回值，返回值类型为 boolean。
     */
    public static List<String> filter(List<String> f,Predicate<String> predicate){
        ArrayList<String> list = new ArrayList<>();
        for (String s:f) {
            if(predicate.test(s)){
                list.add(s);
            }
        }
        return  list;
    }



}
