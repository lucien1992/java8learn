package demo.Test.JAVA8NewCharacteristic.Optional;

import org.junit.Test;

import java.util.Optional;

public class optionalTest0 {
    /**
     * Optional是一个没有子类的工具类，Optional是一个可以为null的容器对象，
     * 它的主要作用就是为了避免Null检查，防止NullpointerException
     */
    @Test
    public void test() {
        /*
         * optional 使用
         */
        Optional<Student> optional = Optional.of(new Student());
        Optional<Student> optional1 = Optional.of(new Student("张三", 11, 90));
        Optional<Object> empty = Optional.empty();

        /**
         * 原先使用
         */
        Student student = new Student("张三", 11, 90);
        if(student!=null){
            if(student.getName()!=null){
                System.out.println(student.getName());
            }
        }

        /**
         * 常见的不优雅的方式
         */
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        if(optionalStudent.isPresent()){
            //get 从 optional 容器中  拿出
            Student student3 = optionalStudent.get();
            System.out.println("name:"+student3.getName());
        }

        /**
         * 正确使用 optional
         */
        //optionalStudent.map(Student::getName).;
        optionalStudent.map(Student::getName).ifPresent(System.out::println);
    }

}
