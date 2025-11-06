public class Test_13 {

    public static void main(String[] args) {
      int i = 0;
      do {
        System.out.printf("i = %d\n", i);
    
        i++;
        if (!(i < 5)) break;
      } while(false);
      System.out.println("Loop finished.");
    }

}