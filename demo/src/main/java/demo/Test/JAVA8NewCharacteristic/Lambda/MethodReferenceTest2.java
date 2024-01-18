package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceTest2 {

    /**
     * 方法引用
     *
     * 1.instanceName::methodName 对象::方法名
     * 2.CassName::staticMethodName 类名::静态方法
     * 3.ClassName::methodName 类名::普通方法
     * 4.ClassName::new 类名::new 调用的构造器
     * 5.TypeName[]::new String[]::new 调用数组的构造器
     */
    @Test
    public void test(){

        /**
         * 静态方法引用
         */
        Function<String, Integer> function = MethodReferenceTest2::staticMethod;
        // 等同于
        //Function<String, Integer> function = (String s) -> MethodReferenceTest2.staticMethod(s);
        Integer result = function.apply("123");
        System.out.println(result);

        /**
         * 指定对象实例方法引用
         */
        MethodReferenceTest2 methodReferenceTest2 = new MethodReferenceTest2();
        Function<String, Integer> function1 = methodReferenceTest2::refMethod;
        // 等同于
        //Function<String, Integer> function1 = (String s) -> methodReferenceTest2.refMethod(s);

        Integer result1 = function1.apply("1234");
        System.out.println(result1);

        /**
         * 特定类型任意对象方法引用
         */
        String[] stringArray = {"C", "a", "B"};
        //Arrays.sort(stringArray,String::compareToIgnoreCase);
        // 等同于
        Arrays.sort(stringArray,(String s1,String s2)->s1.compareToIgnoreCase(s2));
        System.out.println(Arrays.toString(stringArray));

        /**
         * 超类方法引用
         */
        Sub sub = new Sub();
        System.out.println(sub.refMethod("12345"));

        /**
         * 构造器方法引用
         */
        Function<String, Person> function2 = Person::new;
        // 等同于
        //Function<String, Person> function2 = (String s) -> new Person(s);
        Person person = function2.apply("zhangsan");
        System.out.println(person.getName());

        /**
         * 数组构造器方法引用
         */
        Function<Integer, Integer[]> function3 = Integer[]::new;
        // 等同于
        //Function<Integer, Integer[]> function3 = (Integer i) -> new Integer[i];
        Integer[] array = function3.apply(10);
        // [null, null, null, null, null, null, null, null, null, null]
        System.out.println(Arrays.toString(array));

    }

    /**
     * 静态方法
     * @param value
     * @return
     */
    public static Integer staticMethod(String value) {
        return Integer.parseInt(value);
    }

    /**
     * 指定对象实例方法
     * @param value
     * @return
     */
    public Integer refMethod(String value) {
        return Integer.parseInt(value);
    }

    /**
     *
     */
    private static class Supper1 {
        private Integer supperRefMethod(String value) {
            return Integer.parseInt(value);
        }
    }

    private static class Sub extends Supper1 {
        private Integer refMethod(String value) {
            Function<String, Integer> function = super::supperRefMethod;
            // 等同于
            //Function<String, Integer> function1 = (String s) -> super.supperRefMethod(s);
            return function.apply(value);
        }
    }

    private static class Person {

        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }



}
