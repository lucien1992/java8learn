package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface_SupplierTest {

    @Test
    public void base2() {
        //供给型接口 Supplier
        List<Integer> list = supply(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out::println);

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



}
