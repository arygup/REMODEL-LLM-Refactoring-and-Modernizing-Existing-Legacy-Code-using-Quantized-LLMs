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

    public static void move(Point p) {
        do_while_loop: do { 
            if (p == null) {
                break do_while_loop;
            }
            p.x += 5; 
        } while(false);
    }

    public static void move_copy(Point p_val) {
        Point p_val_copy = new Point(p_val);
        p_val_copy.x += 100;
        System.out.println("Inside move_copy: " + p_val_copy.x);
    }

    public static void main(String[] args) throws IOException {
    
            final int SIZE = 10;
    
            byte[] bytes = new byte[SIZE];
            InputStream inStream = System.in;
            OutputStream outStream = System.out;
    
            Point p1 = new Point();
            outStream.write("Original: ".getBytes());
            printNum(p1.x, outStream);
    
            moveCopy(p1);
            outStream.write("\nAfter move_copy: ".getBytes());
            printNum(p1.x, outStream);
    
            move(p1);
            outStream.write("\nAfter move: ".getBytes());
            printNum(p1.x, outStream);
    
        }
    
        public static void moveCopy(Point pValOrig) {
            Point pVal = new Point(pValOrig);
            pVal.x += 100;
        }

}