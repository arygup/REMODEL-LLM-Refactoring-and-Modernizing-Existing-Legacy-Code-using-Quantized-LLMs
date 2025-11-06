public class Test_17 {

    public static void main(String[] args) {
      int x = 10;
      int y = 20;
    
      System.out.println("Value A: " + x);
      System.out.println("Value B: " + y);
    
      long sum = ((long)x + (long)y); // Convert to long for overflow protection
      System.out.println("Sum: " + sum);
    
      return;
    }

}