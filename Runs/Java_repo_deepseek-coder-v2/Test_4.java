public class Test_4 {

    public static void main(String[] args) {
      int i = 5;
      int j = 10;
      int k = ((i++) > (j++)) ? (i++) : (j++);
      System.out.printf("k: %d, i: %d, j: %d\n", k, i, j);
    }

}