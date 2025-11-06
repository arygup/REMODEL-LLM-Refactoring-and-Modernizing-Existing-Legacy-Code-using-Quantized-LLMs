public class Test_9 {

    public static class TypeA {
        public int value;
    
        // Default constructor
        public TypeA() {}
    
        // Copy constructor
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        // Constructor with all fields
        public TypeA(int value) {
            this.value = value;
        }
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
        struct_TypeA a = (struct_TypeA) data;
        System.out.println("TypeA: " + a.value);
      }
      else
        if (type == 2) {
          struct_TypeB b = (struct_TypeB) data;
          System.out.println("TypeB: " + b.value);
        }
    }

    public static void main(String[] args) {
      struct TypeA a = new struct_TypeA(123);
      struct TypeB b = new struct_TypeB(456.789);
    
      int do_while_loop = 1;
      do {
        printGeneric(a, 1);
        if (do_while_loop == 2) break;
        do_while_loop++;
      } while(false);
    
      System.out.println("Overflow ( + 1):" + b.value);
    }

}