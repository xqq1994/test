package datastructure.singleton;

public class Singleton {
    private static volatile Singleton singleton = null;

    public Singleton() {
    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
