    package demo.Test.JAVA8NewCharacteristic.Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

    /**
     * 通过集合创建流  有6中方法可以获取流。
     * 1.通过集合创建流
     * 2.通过数组创建流
     * 3.通过Stream.of方法创建流
     * 4.创建规律的无限流
     * 5.创建无限流
     * 6.创建空流
     */
    @Test
    public void test(){
        // 1.通过集合创建流
        List<String> strings = Arrays.asList("1", "2", "3");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // 2.通过数组创建流
        int[] arr = new int[]{1,2,3};
        IntStream stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // 3.通过Stream.of方法创建流
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        stream2.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // 4.创建规律的无限流
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 3).limit(3);
        stream3.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // 5.创建无限流
        Stream<String> stream4 = Stream.generate(() -> "number" + new Random().nextInt()).limit(3);
        stream4.forEach(System.out::println);
        System.out.println("--------------------------------------------");
        // 6.创建空流
        Stream<Object> stream5 = Stream.empty();
        stream5.forEach(System.out::println);
    }


}
