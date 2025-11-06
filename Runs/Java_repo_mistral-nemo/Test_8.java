public class Test_8 {

    public static class Flags {
        private int value;
    
        public Flags() {}
    
        public Flags(Flags other) {
            this.value = other.value;
        }
    
        public Flags(int a, int b, int c) {
            this.value = (a << 10) | (b << 7) | (c);
        }
    
        public void setA(boolean value) {
            this.value &= ~(1 << 10);
            if (value)
                this.value |= 1 << 10;
        }
    
        public boolean isA() {
            return (this.value & (1 << 10)) != 0;
        }
    
        public void setB(int value) {
            this.value &= ~(7 << 7);
            this.value |= (value & 7) << 7;
        }
    
        public int getB() {
            return (this.value >> 7) & 7;
        }
    
        public void setC(int value) {
            this.value &= ~127;
            this.value |= value & 127;
        }
    
        public int getC() {
            return this.value & 127;
        }
    }

    public static void main(String[] args) {
      Flags f = new Flags();
      f.a = 1;
      f.b = 5;
      f.c = 100;
      System.out.println("Flag a: " + Integer.toUnsignedString(f.a));
      System.out.println("Flag b: " + Integer.toUnsignedString(f.b));
      System.out.println("Flag c: " + Integer.toUnsignedString(f.c));
      f.b = 10;
      System.out.println("Flag b (overflow): " + Integer.toUnsignedString(f.b));
    }

}