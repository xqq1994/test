package datastructure.test;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureClass {
    Object object;
    public Object test() {
        CompletableFuture<Object> async = CompletableFuture.supplyAsync(this::getJdbc);
        CompletableFuture<Object> async1 = async.thenApplyAsync(o -> check(o, object));
        Object o = async1.join();
        return o;
    }

    public Object check(Object o,Object object) {
        try {
            Thread.sleep(1000);
            System.out.println("check");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Object();
    }
    public Object getJdbc(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getJdbc");
        return new Object();
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        CompletableFutureClass aClass = new CompletableFutureClass();
        aClass.test();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
}
