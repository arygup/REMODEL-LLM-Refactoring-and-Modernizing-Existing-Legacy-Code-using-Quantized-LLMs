public class Test_2 {

    public static class Point {
        public int x;
        public int y;
    
        // Default constructor
        public Point() {} 
    
        // Copy constructor
        public Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }
    
        // All-field constructor
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void move(Point p){ p.x += 5; }

    public static void moveCopy(Point pVal) {
      pVal.x += 100;
      System.out.println("Inside move_copy: " + pVal.x);
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