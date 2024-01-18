package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

import java.util.ArrayList;

public class LambdaTest5 {

    @Test
    /**
     * 实际应用
     */
    public void base2() {
        ArrayList<Dog> list = new ArrayList<>();
        list.add(new Dog("bb",2));
        list.add(new Dog("aa",1));
        list.add(new Dog("cc",3));
        list.add(new Dog("ee",5));
        list.add(new Dog("dd",4));


        System.out.println("lambda 集合排序");
        list.sort((a1,a2)-> a1.getAge()-a2.getAge());
        System.out.println(list);

        System.out.println("lambda 遍历");
        list.forEach(System.out::print);
        list.forEach(System.out::println);

    }


}
