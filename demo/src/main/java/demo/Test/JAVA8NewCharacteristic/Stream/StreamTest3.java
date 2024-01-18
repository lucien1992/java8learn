    package demo.Test.JAVA8NewCharacteristic.Stream;

import com.beust.ah.A;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

    public class StreamTest3 {

        /**
         * Stream操作分类
         *  1.中间操作又可以分为无状态（Stateless）与有状态（Stateful）操作，
         *      1.1无状态是指元素的处理不受之前元素的影响，
         *          filter：过滤流，过滤流中的元素
         *          map：转换流，将一种类型的流转换为另外一种类型的流
         *          flapMap：拆解流，将流中每一个元素拆解成一个流
         *      1.2有状态是指该操作只有拿到所有元素之后才能继续下去。
         *          distinct：元素去重
         *          sorted：元素排序
         *          limit：获取前面的指定数量的元素
         *          skip：跳过前面指定数量的元素，获取后面的元素
         *          concat：把两个stream合并成一个stream
         *  2.终结操作又可以分为短路（Short-circuiting）与非短路（Unshort-circuiting）操作，
         *      2.1短路是指遇到某些符合条件的元素就可以得到最终结果，
         *          forEach：遍历
         *          toArray：将流转换为Object数组
         *          reduce : 归约，可以将流中的元素反复结合起来，得到一个值
         *          collect：收集，将流装换为其他形式，比如List，Set，Map
         *          max：返回流的最大值，无方法参数
         *          min：返回流中的最小值，无方法参数
         *          count：返回流中的元素总个数，无方法参数
         *          summaryStatistics：获取汇总统计数据，比如最大值，最小值，平均值等
         *      2.2非短路是指必须处理完所有元素才能得到最终结果。
         *          anyMatch：检查是否有一个元素匹配，方法参数为断言型接口
         *          allMatch：检查是否匹配所有元素，方法参数为断言型接口
         *          findFirst：返回第一个元素，无方法参数
         *          findAny：返回当前流的任意元素，无方法参数
         *          noneMatch：检查是否没有匹配所有元素，方法参数为断言型接口
         *  3.Optional类型
         *      通常聚合操作会返回一个Optional类型，Optional表示一个安全的指定结果类型，
         *      所谓的安全指的是避免直接调用返回类型的null值而造成空指针异常，
         *      调用optional.ifPresent()可以判断返回值是否为空，
         *      或者直接调用ifPresent(Consumer<? super T> consumer)在结果不为空时进行消费操作
         *      ；调用optional.get()获取返回值。
         */
        @Test
        public void testFilter() {
            Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Arrays.stream(arr).filter(x->x>3 && x<8).forEach(System.out::println);
        }


        @Test
        public void testMap() {
            String[] arr = new String[]{"yes", "YES", "no", "NO"};
            //Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
            Arrays.stream(arr).map(x->x.toLowerCase()).forEach(System.out::println);
        }

        @Test
        public void testFlatMap() {
            String[] arr1 = {"a", "b"};
            String[] arr2 = {"e", "f"};
            String[] arr3 = {"h", "j"};
            // Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
            //Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
            Stream.of(arr1,arr2,arr3).flatMap(Arrays::stream).forEach(System.out::println);

            /**
             * 使用红色标记的列表和绿色标记的列表，经过flatmap方法后在第二个管道中把把上述两个列表的数据合并成一个列表数据
             * 由于上述 lists.stream() 后返回的是stream<list> 所以需要使用flatMap 进行合并
             */
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(4444);
            list.add(33333);
            list.add(444444);
            lists.add(list);
            Stream<List<Integer>> stream = lists.stream();
            lists.stream().flatMap(Collection::stream).forEach(System.out::println);
        }

        @Test
        public void testDistinct() {
            List<String> list = new ArrayList<String>() {
                {
                    add("user1");
                    add("user2");
                    add("user2");
                    add("user2");
                }
            };
            //list.stream().distinct().forEach(System.out::println);
            list.stream().distinct().forEach(System.out::println);
        }


        @Test
        public void testSorted1() {
            String[] arr1 = {"abc", "a", "bc", "abcd"};
            // 按照字符长度排序
            System.out.println("lambda表达式");
            Arrays.stream(arr1).sorted((x, y) -> {
                if (x.length() > y.length())
                    return 1;
                else if (x.length() < y.length())
                    return -1;
                else
                    return 0;
            }).forEach(System.out::println);
            // Comparator.comparing是一个键提取的功能
            System.out.println("方法引用");
            Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        }

        /**
         * 倒序
         * reversed(),java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
         * Comparator.reverseOrder():也是用于翻转顺序，用于比较对象（Stream里面的类型必须是可比较的）
         * Comparator.naturalOrder()：返回一个自然排序比较器，用于比较对象（Stream里面的类型必须是可比较的）
         */
        @Test
        public void testSorted2_() {
            String[] arr1 = {"abc", "a", "bc", "abcd"};
            System.out.println("reversed(),这里是按照字符串长度倒序排序");
//            Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
            Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
            System.out.println("Comparator.reverseOrder(),这里是按照首字母倒序排序");
//            Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
            Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
            System.out.println("Comparator.naturalOrder(),这里是按照首字母顺序排序");
//            Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
            Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        }


        /**
         * thenComparing
         * 先按照首字母排序
         * 之后按照String的长度排序
         */
        @Test
        public void testSorted3() {
            String[] arr1 = {"abc", "a", "bc", "abcd"};
//            Arrays.stream(arr1).sorted(Comparator.comparing(this::firstChar).thenComparing(String::length)).forEach(System.out::println);
            Arrays.stream(arr1).sorted(Comparator.comparing(this::firstChar).thenComparing(String::length)).forEach(System.out::println);
        }
        public char firstChar(String x) {
            return x.charAt(0);
        }

        /**
         * limit，限制从流中获得前n个数据
         */
        @Test
        public void testLimit() {
            Stream.iterate(1, x -> x + 2).limit(3).forEach(System.out::println);
        }

        /**
         * skip，跳过前n个数据
         */
        @Test
        public void testSkip() {
//            Stream.iterate(1, x -> x + 2).skip(1).limit(3).forEach(System.out::println);
            Stream.iterate(1,x->x+2).skip(1).limit(5).forEach(System.out::println);
        }


        /**
         * 可以把两个stream合并成一个stream（合并的stream类型必须相同）
         * 只能两两合并
         */
        @Test
        public void testConcat(){
            // 1,3,5
            Stream<Integer> stream1 = Stream.iterate(1, x -> x + 2).limit(3);
            // 3,5,7
            Stream<Integer> stream2 = Stream.iterate(1, x -> x + 2).skip(1).limit(3);
//            Stream.concat(stream1,stream2).distinct().forEach(System.out::println);
            Stream.concat(stream1,stream2).distinct().forEach(System.out::println);
            //Stream.of(arr1,arr2,arr3).flatMap(Arrays::stream).forEach(System.out::println);



        }


        @Test
        public void testForEach() {
            List<String> list = new ArrayList<String>() {
                {
                    add("a");
                    add("b");
                }
            };
            list.stream().forEach(System.out::println);
        }


        @Test
        public void testReduce() {
            /**
             * 归约，可以将流中的元素反复结合起来，得到一个值
             */
//            Optional<Integer> optional = Stream.of(1, 2, 3).filter(x -> x > 1).reduce((x, y) -> x + y);
//            System.out.println(optional.get());

            //Stream.of(1,2,3).filter(x->x>0).forEach(System.out::println);
            System.out.println(Stream.of(1, 2, 3).filter(x -> x > 0).reduce((x, y) -> x + y).get());
        }

        @Test
        public void testCollect() {
            List<User> users = Arrays.asList(new User("张三", 19, 1000),
                    new User("张三", 58, 2000),
                    new User("李四", 38, 3000),
                    new User("赵五", 48, 4000)
            );
            System.out.println(users.stream().map(x -> x.getName()).collect(Collectors.toList()));
            System.out.println(users.stream().map(x -> x.getName()).collect(Collectors.toSet()));
            System.out.println(users.stream().collect(Collectors.toMap(x -> x.getAge(), x -> x.getName())));
            /**
             * java.lang.IllegalStateException: Duplicate key 19
             * 作为key的属性有重复，没有办法确定使用哪个元素来作为转换后map中的value
             */
//            System.out.println(users.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getAge())));
            System.out.println(users.stream().collect(Collectors.toMap(x -> x.getSalary(), x -> x.getAge())));
        }


        @Test
        public void testGroupby() {
            List<User> users = Arrays.asList(new User("张三", 19, 1000),
                    new User("张三", 58, 2000),
                    new User("李四", 38, 3000),
                    new User("赵五", 48, 4000)
            );
            /*Map<String, List<User>> collect3 = users.stream().collect(Collectors.groupingBy(x -> x.getName()));
            System.out.println(collect3);*/
            System.out.println(users.stream().collect(Collectors.groupingBy(x -> x.getName())));
        }


        @Test
        public void testPartitioningBy() {
            List<User> users = Arrays.asList(new User("张三", 19, 1000),
                    new User("张三", 58, 2000),
                    new User("李四", 38, 3000),
                    new User("赵五", 48, 4000)
            );
            /*Map<Boolean, List<User>> map = users.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 2500));
            map.forEach((x, y) -> System.out.println(x + "->" + y));*/

            users.stream().collect(Collectors.partitioningBy(x->x.getSalary()>2500)).forEach((x,y)-> System.out.println(x+"->"+y));

        }


        @Test
        public void testMaxAndMin() {
            String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
            /*Stream.of(arr).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
            Stream.of(arr).min(Comparator.comparing(String::length)).ifPresent(System.out::println);*/

            Stream.of(arr).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
            Stream.of(arr).min(Comparator.comparing(String::length)).ifPresent(System.out::println);
        }

        @Test
        public void testCount(){
            String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
            long count = Stream.of(arr).count();
            System.out.println(count);
        }


        @Test
        public void testSummaryStatistics() {
            /**
             * 我们可以使用summaryStatistics方法获得stream中元素的各种汇总数据
             */
            //计算 count, min, max, sum, and average for numbers
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            // IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
            /*IntSummaryStatistics stats = numbers
                    .stream()
                    .mapToInt(x -> x)
                    .summaryStatistics();*/
            IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();


            System.out.println("List中最大的数字 : " + stats.getMax());
            System.out.println("List中最小的数字 : " + stats.getMin());
            System.out.println("所有数字的总和   : " + stats.getSum());
            System.out.println("所有数字的平均值 : " + stats.getAverage());
        }

        @Test
        public void testAnyMatch() {
            //检查是否有一个元素匹配，方法参数为断言型接口
            String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
            /*Boolean aBoolean = Stream.of(arr).anyMatch(x -> x.startsWith("a"));
            System.out.println(aBoolean);*/

            System.out.println(Stream.of(arr).anyMatch(x -> x.startsWith("a")));
        }

        @Test
        public void testFindFirst() {
            //返回第一个元素，无方法参数
            String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
            /*String str = Stream.of(arr).parallel().filter(x -> x.length() > 3).findFirst().orElse("noghing");
            System.out.println(str);*/
            //parallel  并行
            System.out.println(Stream.of(arr).parallel().filter(x -> x.length() > 3).findFirst().orElse("no"));
        }


        /**
         * findAny
         * 找到所有匹配的元素
         * 对并行流十分有效
         * 只要在任何片段发现了第一个匹配元素就会结束整个运算
         */
        @Test
        public void testFindAny() {
            String[] arr = new String[]{"b", "ab", "abc", "abcd", "abcde"};
            /*Optional<String> optional = Stream.of(arr).parallel().filter(x -> x.length() > 2).findAny();
            optional.ifPresent(System.out::println);*/
            Stream.of(arr).parallel().filter(x->x.length()>1).findAny().ifPresent(System.out::println);
        }


        @Test
        public void testOptional() {
            List<String> list = new ArrayList<String>() {
                {
                    add("user1");
                    add("user2");
                }
            };
            Optional<String> opt = Optional.of("user3");
            opt.ifPresent(list::add);
            list.forEach(System.out::println);
        }


        @Test
        public void testOptional2() {
            Integer[] arr = new Integer[]{4, 5, 6, 7, 8, 9};
            Integer result = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElse(-1);
            System.out.println(result);
            Integer result1 = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElseGet(() -> -1);
            System.out.println(result1);
            Integer result2 = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
            System.out.println(result2);
        }

        /**
         * 原始类型流的初始化
         */
        @Test
        public void testRawStream1() {
            IntStream intStream = IntStream.of(1, 3);
            IntStream stream1 = IntStream.rangeClosed(0, 1);
            IntStream stream2 = IntStream.range(0, 1);
            intStream.forEach(System.out::println);
            System.out.println("包括右边界");
            stream1.forEach(System.out::println);
            System.out.println("不包括右边界");
            stream2.forEach(System.out::println);
        }



    }
