public class Test_1 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int p_index = 0;
        int[] p_array = arr;
        System.out.println(p_array[p_index]);
        p_index++;
        System.out.println(p_array[p_index]);
        System.out.println(p_array[p_index + 2]);
    }

}