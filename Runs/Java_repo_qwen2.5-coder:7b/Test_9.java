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

    public static class TypeB {
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
        StructTypeA a = (StructTypeA) data;
        System.out.println("TypeA: " + a.value);
      } else if (type == 2) {
        StructTypeB b = (StructTypeB) data;
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