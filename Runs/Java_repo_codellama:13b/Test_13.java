public class Test_13 {

    public static int main() {
      int i = 0;
      do {
        System.out.printf("i = %d\n", i);
    
        i++;
        if (i < 5) break do_while_loop;
        System.out.println("Loop finished.");
        return 0;
      } while(false);
    }

}