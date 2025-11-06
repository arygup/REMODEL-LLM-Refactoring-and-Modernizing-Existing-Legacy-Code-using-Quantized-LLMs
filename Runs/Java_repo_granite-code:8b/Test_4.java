public class Test_4 {

    public static void main(String[] args) {
        int i = 5;
        int j = 10;
        long k;
        do {
            if (i > j) {
                k = i++;
            } else {
                k = j++;
            }
        } while (false);
        System.out.printf("k: %d, i: %d, j: %d\n", k & 0xFFFFFFFFL, i, j);
    }

}