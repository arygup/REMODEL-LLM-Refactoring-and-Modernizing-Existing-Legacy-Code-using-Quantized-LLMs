public class Test_8 {

    public static class Flags {
        private int data;
    
        public Flags() {
            this.data = 0;
        }
    
        public Flags(Flags other) {
            this.data = other.data;
        }
    
        public Flags(int a, int b, int c) {
            setA(a);
            setB(b);
            setC(c);
        }
    
        public int getA() {
            return (data >> 0) & 1;
        }
    
        public void setA(int a) {
            if (a == 1) {
                data |= (1 << 0);
            } else {
                data &= ~(1 << 0);
            }
        }
    
        public int getB() {
            return (data >> 1) & 7;
        }
    
        public void setB(int b) {
            if (b >= 0 && b <= 7) {
                data = (data & ~(0x7 << 1)) | ((b & 0x7) << 1);
            }
        }
    
        public int getC() {
            return (data >> 4) & 0x7F;
        }
    
        public void setC(int c) {
            if (c >= 0 && c <= 127) {
                data = (data & ~(0x7F << 4)) | ((c & 0x7F) << 4);
            }
        }
    }

    public static void main(String[] args) {
        class Flags {
            long a;
            long b;
            long c;
    
            Flags() {
                this.a = 0;
                this.b = 0;
                this.c = 0;
            }
    
            int getA() { return (int)(this.a & 0xFFFFFFFFL); }
            void setA(int value) { this.a = ((long)value & 0x1) << 0; }
            
            int getB() { return (int)((this.b >> 1) & 0xFFFFFFFFL); }
            void setB(int value) { this.b = (((long)value & 0x7) << 1); }
    
            int getC() { return (int)((this.c >> 3) & 0xFFFFFFFFL); }
            void setC(int value) { this.c = (((long)value & 0x7F) << 3); }
        }
    
        Flags f = new Flags();
        f.setA(1);
        f.setB(5);
        f.setC(100);
    
        System.out.printf("Flag a: %u\n", f.getA());
        System.out.printf("Flag b: %u\n", f.getB());
        System.out.printf("Flag c: %u\n", f.getC());
    
        f.setB(10);
        System.out.printf("Flag b (overflow): %u\n");
    }

}