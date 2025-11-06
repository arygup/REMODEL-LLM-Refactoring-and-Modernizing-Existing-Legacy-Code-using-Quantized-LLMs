public class Test_4 {

    public static void main(String[] args) {
      int i = 5;
      int j = 10;
      do_while_loop: do {
        int k = ((i++) > (j++)) ? (i++) : (j++);
        System.out.println("k: " + k + ", i: " + i + ", j: " + j);
      } while(false);
    
    }

}