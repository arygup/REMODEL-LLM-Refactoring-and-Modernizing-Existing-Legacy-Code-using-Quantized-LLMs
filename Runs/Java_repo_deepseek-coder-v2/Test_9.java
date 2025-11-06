public class Test_9 {

    public static class TypeA {
        public int value;
    
        // No-argument constructor
        public TypeA() {}
    
        // Copy constructor
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        // All-field constructor
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        // Default constructor
        public TypeB() {}
    
        // Copy constructor
        public TypeB(TypeB other) {
            this.value = other.value;
        }
    
        // All-field constructor
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void printGeneric(Object data, int type) {
        if (type == 1) {
            struct TypeA a = (struct TypeA) data;
            System.out.printf("TypeA: %d\n", a.value);
        } else if (type == 2) {
            struct TypeB b = (struct TypeB) data;
            System.out.printf("TypeB: %f\n", b.value);
        }
    }

    public static void main(String[] args) {
      struct TypeA a = new struct TypeA();
      a.value = 123;
      struct TypeB b = new struct TypeB();
      b.value = 456.789;
      printGeneric(a, 1);
      printGeneric(b, 2);
    }

}