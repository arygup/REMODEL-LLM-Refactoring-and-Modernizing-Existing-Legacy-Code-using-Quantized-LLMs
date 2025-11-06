public class Test_8 {

    public static class Flags {
        private int a;
        private int b;
        private int c;
    
        public Flags() {}
    
        public Flags(Flags other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Flags(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    
        public int getA() {
            return a;
        }
    
        public void setA(int a) {
            this.a = a;
        }
    
        public int getB() {
            return b;
        }
    
        public void setB(int b) {
            this.b = b;
        }
    
        public int getC() {
            return c;
        }
    
        public void setC(int c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
      Flags f = new Flags();
      f.a = 1;
      f.b = 5;
      f.c = 100;
      System.out.printf("Flag a: %d\n", f.a);
      System.out.printf("Flag b: %d\n", f.b);
      System.out.printf("Flag c: %d\n", f.c);
      f.b = 10;
      System.out.printf("Flag b (overflow): %d\n", f.b);
    }

}