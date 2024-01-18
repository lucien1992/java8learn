package demo.Test.Thread;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread4New2 implements Callable<String> {
    /**
     * 创建线程的四种方式
     * 实现Callable接口进行创建
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "1024";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread4New2 myCallable = new Thread4New2();
        FutureTask<String> task = new FutureTask<String>(myCallable);
//        new Thread(task, "A").start();
//        new Thread(task, "B").start();
//        new Thread(task, "C").start();
        for (int i = 0; i < 100; i++) {
            new Thread(task, i+"").start();
        }

        String string = task.get(); //获取返回值
        System.out.println(string);
    }
}




