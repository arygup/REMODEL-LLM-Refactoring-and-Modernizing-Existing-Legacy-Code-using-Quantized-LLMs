public class Test_2 {

    public static class Point {
      public int x;
      public int y;
    
      public Point() {}
    
      public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
      }
    
      public Point(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    public static void move(Point p) {
      p.x += 5;
    }

    public static void move_copy(Point p_val) {
      p_val.x += 100;
      System.out.println("Inside move_copy: " + p_val.x);
    }

    public static void main(String[] args) {
      Point p1 = new Point(10, 20);
      System.out.println("Original: " + p1.x);
      move_copy(p1);
      System.out.println("After move_copy: " + p1.x);
      move(p1);
      System.out.println("After move: " + p1.x);
    }

}