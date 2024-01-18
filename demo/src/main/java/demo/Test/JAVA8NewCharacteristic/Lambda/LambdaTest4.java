package demo.Test.JAVA8NewCharacteristic.Lambda;

import org.junit.Test;

public class LambdaTest4 {

    @Test
    /**
     * 有参无参
     */
    public void base2() {
        DogService dogService = Dog::new;
        System.out.println(dogService.dog());


        DogService2 dogService2 = Dog::new;
        System.out.println(dogService2.dog("小花",11));
    }

    interface DogService{
        Dog dog();
    }

    interface DogService2{
        Dog dog(String name, int age);
    }

}
