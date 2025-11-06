public class Test_9 {

    public static class TypeA {
        public int value;
    
        public TypeA() {
        }
    
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        public TypeB() {
        }
    
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
            System.out.printf("TypeA: %d\n", a.value);
        } else if (type == 2) {
            TypeB b = (TypeB) data;
            System.out.printf("TypeB: %f\n", b.value);
        }
    }

    public static void printGeneric(Object a, int type) {
        if (type == 1) {
            TypeA ta = (TypeA) a;
            System.out.println("TypeA value: " + ta.value);
        } else if (type == 2) {
            TypeB tb = (TypeB) a;
            System.out.println("TypeB value: " + tb.value);
        }
    }

}