package datastructure.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class CompletionServiceTest {
    public Integer getPriceByS1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public Integer getPriceByS2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public Integer getPriceByS3() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public Integer save(Integer r) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return r;
    }

    public Integer test() throws Exception {
        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        // 创建 CompletionService
        CompletionService<Integer> cs = new
                ExecutorCompletionService<>(executor);
        // 异步向电商 S1 询价
        cs.submit(() -> getPriceByS1());
        // 异步向电商 S2 询价
        cs.submit(() -> getPriceByS2());
        // 异步向电商 S3 询价
        cs.submit(() -> getPriceByS3());
        // 将询价结果异步保存到数据库
        // 并计算最低报价
        AtomicReference<Integer> m = new AtomicReference<>(Integer.MAX_VALUE);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Integer r = null;
                try {
                    r = cs.take().get();
                } catch (Exception e) {
                }
                save(r);
                m.set(Integer.min(m.get(), r));
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        return m.get();
    }

    public static void main(String[] args) throws Exception {
        CompletionServiceTest test = new CompletionServiceTest();
        Integer test1 = test.test();
        System.out.println(test1);

    }
}
