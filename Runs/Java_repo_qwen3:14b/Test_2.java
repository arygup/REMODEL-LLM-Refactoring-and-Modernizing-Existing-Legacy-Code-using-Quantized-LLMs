public class Test_2 {

    public static class Point {
        public int x;
        public int y;
    
        public Point() {
        }
    
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

    public static void move_copy(Point p_val_orig) { Point p_val = new Point(p_val_orig); p_val.x += 100; System.out.printf("Inside move_copy: %d\n", p_val.x); }

    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.printf("Original: %d\n", p1.x);
        move_copy(p1);
        System.out.printf("After move_copy: %d\n", p1.x);
        move(p1);
        System.out.printf("After move: %d\n", p1.x);
    }

}