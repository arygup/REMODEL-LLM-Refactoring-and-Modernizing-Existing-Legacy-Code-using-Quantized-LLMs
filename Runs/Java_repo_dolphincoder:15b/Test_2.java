public class Test_2 {

    public static class Point {
    
        public int x;
        public int y;
    
        // Public no-argument default constructor
        public Point() {}
    
        // Public copy constructor
        public Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }
    
        // Public all-field constructor
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // Note: Bitfields will be handled in a separate task.

    public static void move(Point p) {
      p.x += 5;
    }

    public static void move_copy(Point p_val) {
      p_val.x += 100;
      System.out.printf("Inside move_copy: %d\n", p_val.x);
    }

    public static void move_copy(Point p1) {
      Point temp = new Point(); 
      temp.x = p1.x; 
      p1.x += 100; 
      printf("After move_copy: %d\n", p1.x); 
    } 
    
    public static void move(Point p2) {
      p2.x += 100; 
      printf("After move: %d\n", p2.x); 
    }

}