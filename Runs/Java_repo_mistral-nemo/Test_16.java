public class Test_16 {

    public static final int g_counter = 10

    public static void increment_global() {
      g_counter += 5;
    }

    public static void main(String[] args) {
      System.out.println("Global: " + g_counter);
      increment_global();
      System.out.println("Global after func: " + g_counter);
      g_counter = 1;
      System.out.println("Global after main: " + g_counter);
    }

}