package demo.Test.ClassTest;

public class Book {
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book() {
        System.out.println("无参构造方法");
    }

    private Book(String name, String author) {
        System.out.println("有参构造方法");
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 0 !";
                break;
            case 1:
                string = "I am declaredMethod 1 !";
                break;
            default:
                string = "I am declaredMethod -1 !";
        }

        return string;
    }


}

