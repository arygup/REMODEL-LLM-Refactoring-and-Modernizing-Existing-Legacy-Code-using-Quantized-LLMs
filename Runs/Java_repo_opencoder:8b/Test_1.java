public class Test_1 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int p_index = 0;
        do_while_loop: do {
            System.out.println(arr[p_index]);
            p_index++;
            System.out.println(arr[p_index]);
            System.out.println(arr[p_index + 2]);
        } while(false);
    }

}