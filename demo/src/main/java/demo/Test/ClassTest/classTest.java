package demo.Test.ClassTest;

import org.junit.Test;

public class classTest {
    @Test
    public void getClz() {
        try {
            // 方法一，使用 Class.forName 静态方法
            Class<?> classBook = Class.forName("demo.Test.ClassTest.Book");

            // 方法二：直接通过 类名.class 的方式得到
            Class clz = Book.class;

            // 方法三：使用类对象的 getClass() 方法。
            Book book1 = new Book();
            Class<? extends Book> book1Class = book1.getClass();

            System.out.println(classBook == clz);
            System.out.println(classBook == book1Class);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
