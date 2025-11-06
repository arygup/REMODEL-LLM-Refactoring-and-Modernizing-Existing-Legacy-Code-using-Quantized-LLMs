public class Test_9 {

    public static class TypeA {
        public int value;
    
        // CONSTRUCTORS (MANDATORY)
        public TypeA() {} // default constructor
        public TypeA(TypeA other) { this.value = other.value; } // copy constructor
        public TypeA(int value) { this.value = value; } // all-field constructor
    }

    public static class TypeB {
        public double value;
    
        public TypeB() {}
    
        public TypeB(TypeB other) {
            this.value = other.value;
        }
    
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void printGeneric(Object data, int type) {
      if (type == 1) {
        TypeA a = (TypeA) data;
        System.out.println("TypeA: " + a.value);
      } else if (type == 2) {
        TypeB b = (TypeB) data;
        System.out.println("TypeB: " + b.value);
      }
    }

    public static void main(String[] args) {
        TypeA a = new TypeA(123);
        TypeB b = new TypeB(456.789);
        printGeneric(a, 1);
        printGeneric(b, 2);
      }

}