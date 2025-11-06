public class Test_8 {

    public static class Flags {
      private int flags;
    
      public Flags() {
        this.flags = 0;
      }
    
      public Flags(Flags other) {
        this.flags = other.flags;
      }
    
      public Flags(int a, int b, int c) {
        this.flags = ((a & 1) << 0) |
                     ((b & 7) << 1) |
                     ((c & 127) << 4);
      }
    
      public int getA() {
        return (this.flags >> 0) & 1;
      }
    
      public void setA(int a) {
        this.flags = (this.flags & ~((1 << 1))) | (((a & 1) << 0) << 0);
      }
    
      public int getB() {
        return (this.flags >> 1) & 7;
      }
    
      public void setB(int b) {
        this.flags = (this.flags & ~((7 << 1))) | (((b & 7) << 1) << 1);
      }
    
      public int getC() {
        return (this.flags >> 4) & 127;
      }
    
      public void setC(int c) {
        this.flags = (this.flags & ~((127 << 4))) | (((c & 127) << 4) << 4);
      }
    }

    public static void main(String[] args) {
            Flags f = new Flags();
            f.a = 1;
            f.b = 5;
            f.c = 100;
            System.out.printf("Flag a: %u\n", f.a);
            System.out.printf("Flag b: %u\n", f.b);
            System.out.printf("Flag c: %u\n", f.c);
            f.b = 10;
            System.out.printf("Flag b (overflow): %u\n", f.b);
        }

}