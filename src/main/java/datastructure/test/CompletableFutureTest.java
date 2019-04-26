package datastructure.test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    static Integer c = 3;
    public static Integer check(int b) {
        try {
            Thread.sleep(1000);
            System.out.println("check");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return b;
    }
    public static Integer getJdbc(int a){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getJdbc");
        return a;
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> getJdbc(1));

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> check(2));

        CompletableFuture<Integer> f3 = f1.thenCombine(f2, (o, o2) -> c);
        Integer join = f3.join();
        System.out.println(join);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
}
