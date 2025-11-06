public class Test_9 {

    public static class TypeA {
        public int value;
        
        // Default constructor
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

    package yourPackageName;
    
    public class TypeB {
        public double value;
        
        // No-argument default constructor
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
          TypeA a = (TypeA) data;
          System.out.printf("TypeA: %d\n", a.value);
        } else if (type == 2) {
          TypeB b = (TypeB) data;
          System.out.printf("TypeB: %f\n", b.value);
        }
      }

    public static void main(String[] args) {
        TypeA a = new TypeA();
        a.value = 123;
        printGeneric(a);
        TypeB b = new TypeB();
        b.value = 456.789;
        printGeneric(b);
    }

}