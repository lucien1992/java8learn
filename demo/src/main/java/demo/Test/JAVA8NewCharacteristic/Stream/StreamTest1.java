package demo.Test.JAVA8NewCharacteristic.Stream;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamTest1 {

    /**
     * Stream 是对集合的包装，通常和lambda一起使用。
     * Stream 主要具有如下三点特性
     *  1.stream不存储数据
     *  2.stream不改变源数据
     *  3.stream的延迟执行特性
     *
     *  由于stream的延迟执行特性，在聚合操作执行前修改数据源是允许的。
     * 当我们操作一个流的时候，并不会修改流底层的集合（即使集合是线程安全的），如果想要修改原有的集合，就无法定义流操作的输出。
     */
    @Test
    public void test(){
        Stream<String> stream = Stream.of("1", "2", "3");

    }
    @Test
    public void testUnlimitStream() {
        Stream<Integer> stream = Stream.iterate(0, x -> x + 2).limit(100);
        stream.forEach(System.out::println);
    }

    /**
     * 延迟执行特性，在聚合操作之前都可以添加相应元素
     */
    @Test
    public void test3() {
        List<String> wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
            }
        };

        Stream<String> words = wordList.stream();
        wordList.add("END");
        long n = words.distinct().count();
        System.out.println(n);
    }

    /**
     * 延迟执行特性，会产生干扰
     */
    @Test
    public void test4(){
        List<String> wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
            }
        };

        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            System.out.println("s->"+s);
            if (s.length() < 4) {
                System.out.println("select->"+s);
                wordList.remove(s);
                System.out.println(wordList);
            }
        });
    }


}
