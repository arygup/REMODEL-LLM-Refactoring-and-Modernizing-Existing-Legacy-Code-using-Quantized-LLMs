public class Test_19 {

    public static class Inner {
    	public int inner_val;
    
    	public Inner() {}
    
    	public Inner(Inner other) {
    		this.inner_val = other.inner_val;
    	}
    
    	public Inner(int inner_val) {
    		this.inner_val = inner_val;
    	}
    }

    public static class Outer {
        public Inner inner_data;
        public char[] name = new char[20];
    
        public Outer() {}
    
        public Outer(Outer other) {
            this.inner_data = other.inner_data;
            System.arraycopy(other.name, 0, this.name, 0, Math.min(this.name.length, other.name.length));
        }
    
        public Outer(Inner inner_data, String name) {
            this.inner_data = inner_data;
            this.name = (name.length() <= 20) ? name.toCharArray() : new char[20];
        }
    }
    
    public static class Inner {
        // ... translate Inner struct here if provided
    }

    public static void main(String[] args) {
      Outer o = new Outer();
      o.inner_data.inner_val = 123;
      System.arraycopy("MyStruct".getBytes(), 0, o.name, 0, Math.min(20, "MyStruct".length()));
      System.out.printf("Name: %s\n", new String(o.name));
      System.out.printf("Inner: %d\n", o.inner_data.inner_val);
    }

}