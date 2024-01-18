package demo.Test.Thread;

public class Thread4New1 implements Runnable{
    /**
     * 创建线程的四种方式
     * .实现Runnable接口进行创建
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我还能学~~" + i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象，调用start()方法启动线程
        Thread4New1 myRunnable = new Thread4New1();

        //通过new Thread()创建一个代理对象
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("学不动了~~" + i);
        }
    }
}




