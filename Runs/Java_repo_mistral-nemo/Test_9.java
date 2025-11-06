public class Test_9 {

    public static class TypeA {
      public int value;
    
      public TypeA() {}
    
      public TypeA(TypeA other) {
        this.value = other.value;
      }
    
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
        TypeA a = (TypeA) data;
        System.out.println("TypeA: " + a.value);
      } else if (type == 2) {
        TypeB b = (TypeB) data;
        System.out.println("TypeB: " + b.value);
      }
    }

    public static void printGeneric(Object obj, int type) {
      if (type == 1 && obj instanceof TypeA) {
        System.out.println(((TypeA) obj).value);
      } else if (type == 2 && obj instanceof TypeB) {
        System.out.printf("%.3f\n", ((TypeB) obj).value);
      }
    }

}