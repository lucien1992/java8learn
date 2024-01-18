package demo.Test.JAVA8NewCharacteristic.Optional;

import org.junit.Test;

import java.util.Locale;
import java.util.Optional;

public class optionalTest1 {
    /**
     * Optional是一个没有子类的工具类，Optional是一个可以为null的容器对象，
     * 它的主要作用就是为了避免Null检查，防止NullpointerException
     */
    @Test
    public void test() {
        /**
         * empty
         * 返回空的 Optional 实例
         */
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());// 抛出 NoSuchElementException

        /**
         *  of(T value)
         *  为非Null值创建一个Optional，传入参数不能为null，否则会抛出NullPointerException。
         */
        Optional<String> userName = Optional.of("userName");
        Optional<Student> student = Optional.of(new Student("", 1, 2));
        //Optional<String> userName1 = Optional.of(null);// 抛出 NullPointerException

        /**
         * ofNullable(T value)
         * 创建可为空的Optional，如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
         */
        Optional<String> userName2 = Optional.ofNullable("userName");

        /**
         * get()
         * 如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException。
         */
        Optional<String> userName3 = Optional.ofNullable("userName");
        System.out.println(userName.get());//输出 userName

        /**
         * isPresent()
         * 如果存在值，则返回true，否则返回false。
         */
        Optional<String> userName4 = Optional.ofNullable("userName");
        System.out.println(userName.isPresent());//输出 true
        Optional<String> empty1 = Optional.ofNullable(null);
        System.out.println(empty1.isPresent());//输出 false

        /**
         * ifPresent(Consumer<? super T> consumer)
         * 如果值存在则使用该值调用 consumer , 否则不执行任何操作
         * 要理解ifPresent方法，首先需要了解Consumer类。
         * 简答地说，Consumer类包含一个抽象方法。该抽象方法对传入的值进行处理，但没有返回值。
         * Java8支持不用接口直接通过lambda表达式传入参数。
         * 如果Optional实例有值，调用ifPresent()可以接受接口段或lambda表达式。
         */
        Optional<String> userName5 = Optional.ofNullable("userName");
        userName5.ifPresent((value) -> System.out.println(value.length()));//输出 8
        Optional<String> empty2 = Optional.ofNullable(null);
        empty2.ifPresent((value) -> System.out.println(value.length()));//无输出，此时Optional为空值，不执行操作

        /**
         * filter(Predicate<? super T> predicate)
         * 如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional。
         */
        Optional<String> userName6 = Optional.ofNullable("userName");
        Optional<String> filterUsername1 = userName6.filter(value -> value.length() > 4);
        System.out.println(filterUsername1.get());//输出 userName
        Optional<String> filterUsername2 = userName6.filter(value -> value.length() < 4);
        System.out.println(filterUsername2.get());//抛出 NoSuchElementException，因为此时没有找到匹配的值，返回一个空的Optional

        /**
         * map(Function<? super T, ? extends U> mapper)
         * 如果有值，则对其执行调用映射函数得到返回值。如果返回值不为 null，则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional。
         */
        Optional<String> userName7 = Optional.ofNullable("userName");
        Optional<String> userNameMap1 = userName7.map(value -> value.toUpperCase(Locale.ROOT));
        Optional<String> userNameMap2 = userName7.map(String::toUpperCase);
        System.out.println(userNameMap1.get());

        /**
         * flatMap(Function<? super T, Optional> mapper)
         * 如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional，
         * 此方法类似于map（Function），但提供的mapper的返回值必须是Optional，如果调用，flatMap不会用附加的Optional包装它
         */

        Optional<String> userName8 = Optional.ofNullable("userName");
        Optional<String> flatMapUserName = userName8.flatMap((value) ->
                Optional.of(value.toUpperCase(Locale.ROOT)) //mapper的返回值必须为Optional
        );
        System.out.println(flatMapUserName.get());//输出 USERNAME

        /**
         * orElse(T other)
         * 如果存在该值，返回值， 否则返回 other。
         */
        Optional<String> userName9 = Optional.ofNullable("userName");
        System.out.println(userName9.orElse("mobile"));//输出 userName
        Optional<Object> empty3 = Optional.empty();
        System.out.println(empty3.orElse("mobile"));//输出 mobile

        /**
         * orElseGet(Supplier<? extends T> other)
         * 如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果。
         * orElseGet与orElse方法类似，区别在于得到的默认值。
         * orElse方法将传入的字符串作为默认值，orElseGet方法可以接受Supplier接口的实现用来生成默认值。
         */
        Optional<String> userName10 = Optional.ofNullable("userName");
        System.out.println(userName10.orElseGet(() -> "mobile"));//输出 userName
        Optional<Object> empty4 = Optional.empty();
        System.out.println(empty4.orElseGet(() -> "mobile"));//输出 mobile

        /**
         * orElseThrow(Supplier<? extends X> exceptionSupplier)
         * 如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常
         */
        try {
            Optional<String> userName11 = Optional.ofNullable("userName");
            System.out.println(userName11.orElseThrow(Exception::new));//输出 userName
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Optional<Object> empty5 = Optional.empty();
            System.out.println(empty5.orElseThrow(Exception::new));
        } catch (Exception e) {
            e.printStackTrace(); //异常捕获
        }


    }


}
