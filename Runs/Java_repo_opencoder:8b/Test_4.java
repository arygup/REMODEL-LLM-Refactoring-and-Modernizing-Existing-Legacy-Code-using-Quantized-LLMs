public class Test_4 {

    public static void main(String[] args) {
        int i = 5;
        int j = 10;
    
        do_while_loop: do {
            int k;
            if ((i++) > (j++)) {
                k = i++;
            } else {
                k = j++;
            }
            System.out.printf("k: %d, i: %d, j: %d\n", k, i, j);
        } while (false);
    
        return;
    }

}