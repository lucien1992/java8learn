    package demo.Test.JAVA8NewCharacteristic.Stream;

import lombok.Synchronized;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

    public class StreamTest4 {

        /**
         *  并行流  异常 处理
         *  1.加同步锁
         *  2.使用线程安全容器
         *  3.通过Stream 中toArray 或者  collect
         */
        @Test
        public void test0(){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
            System.out.println(arrayList.size());
            //并行流向集合中添加数据
            ArrayList<Integer> arrayListNew = new ArrayList<>();
            arrayList.parallelStream()
                    .forEach(arrayListNew::add);//可能抛出异常
            System.out.println(arrayListNew.size());

        }

        @Test
        public void test1(){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
            System.out.println(arrayList.size());
            ArrayList<Integer> arrayListNew = new ArrayList<>();
            Object o = new Object();
            arrayList.parallelStream()
                    .forEach(s-> {
                        //同步代码块
                        synchronized (o) {
                            arrayListNew.add(s);
                        }
                    });
            System.out.println(arrayListNew.size());

        }

        @Test
        public void test2(){
            //线程不安全的容器包装为线程安全的容器
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<Integer> synchronizedList = Collections.synchronizedList(arrayList);
            Object o = new Object();
            IntStream.rangeClosed(1,10000)
                    .parallel()
                    .forEach(
                            i->{synchronizedList.add(i);}
                    );
            System.out.println(synchronizedList.size());
        }

        /**
         * toArray  collect
         */
        @Test
        public void test3(){
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<Integer> synchronizedList = Collections.synchronizedList(arrayList);
            Object o = new Object();
            IntStream.rangeClosed(1,10000)
                    .parallel()
                    .boxed()
                    .collect(Collectors.toList());
            System.out.println(synchronizedList.size());
        }

    }
