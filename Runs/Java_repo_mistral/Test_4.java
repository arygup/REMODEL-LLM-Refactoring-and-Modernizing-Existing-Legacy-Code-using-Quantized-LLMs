public class Test_4 {

    public static void main() {
      int i = 5;
      int j = 10;
      int k = ((i + 1) > (j + 1)) ? (i + 1) : (j + 1);
      System.out.printf("k: %d, i: %d, j: %d\n", k, i, j);
    }

}