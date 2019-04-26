package datastructure.test;

// Run with -XX:+UnlockDiagnosticVMOptions -XX:+PrintBiasedLockingStatistics -XX:TieredStopAtLevel=1
public class SynchronizedTest {


  public static void main(String[] args) throws InterruptedException {
    String a = "a"+"b";
    String b = "ab";
    System.out.println(a);
    System.out.println(b);
  }

}
