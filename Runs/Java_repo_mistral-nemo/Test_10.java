public class Test_10 {

    public static void createInt(Integer[] p)
    {
      p[0] = Integer.valueOf(42);
    }

    public static void main(String[] args)
    {
      int myIntPtr = 0;
      createInt(myIntPtr);
      if (myIntPtr != 0)
      {
        System.out.println("Value from out-param: " + myIntPtr);
      }
    }

}