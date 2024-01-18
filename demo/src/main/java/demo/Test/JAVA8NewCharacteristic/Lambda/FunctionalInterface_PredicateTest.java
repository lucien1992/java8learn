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
public class FunctionalInterface_PredicateTest {

    @Test
    public void base2() {

        //断言型接口 Predicate
        /*List<String> strings = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> strings1 = filter(strings, f -> f.length() == 2);
        System.out.println(strings1);*/

        filter1("HelloWold",(str)->str.contains("H"),(str)->str.contains("W"));
    }


    /**
     *  断言型接口 Predicate
     * 断言型又名判断型。 Predicate 只有一个抽象方法 test，参数列表只有一个参数为 T，有返回值，返回值类型为 boolean。
     */
    public static List<String> filter(List<String> f, Predicate<String> predicate){
        ArrayList<String> list = new ArrayList<>();
        for (String s:f) {
            if(predicate.test(s)){
                list.add(s);
            }
        }
        return  list;
    }

    public static void filter1(String str,Predicate<String> p, Predicate<String> p1){

        //既包含 H 又包含 W
        boolean test = p.and(p1).test(str);
        //包含 H 或者 包含 W
        boolean test1 = p.or(p1).test(str);
        //不包含H
        boolean test2 = p.negate().test(str);
        //不包含W
        boolean test3 = p1.negate().test(str);

        System.out.println(test);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }



}
