public class Test_13 {

    public static void main() {
      int i = 0;
    
      do_while_loop:
      do {
        System.out.printf("i = %d\n", i);
    
        i++;
        if (i < 5) continue do_while_loop;
    
      } while(false);
      
      System.out.println("Loop finished.");
    }

}