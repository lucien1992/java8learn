package demo.Test.Thread;

public class Thread4New0 {
    /**
     * 创建线程的四种方式
     * 通过继承Thread类来进行创建
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程创建");
    }
}

