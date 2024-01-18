package demo.Test.JAVA8NewCharacteristic.Lambda;

public class Dog {
    private final static String TAG = "BookTag";

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", author='" + age + '\'' +
                '}';
    }

    public Dog() {
        System.out.println("无参构造方法");
    }

    public Dog(String name, int age) {
        System.out.println("有参构造方法");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

