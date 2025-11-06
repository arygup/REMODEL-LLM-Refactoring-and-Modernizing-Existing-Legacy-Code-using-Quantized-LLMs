public class Test_14 {

    public static void main(String[] args) {
        char[] dest = new char[50];
        char[] src = "World".toCharArray();
        
        System.arraycopy("Hello ".toCharArray(), 0, dest, 0, 6);
        System.arraycopy(src, 0, dest, 6, src.length);
        
        String resultString = new String(dest).trim();
        System.out.println("String: " + resultString);
        
        int length = resultString.length();
        System.out.println("Length: " + length);
    }

}