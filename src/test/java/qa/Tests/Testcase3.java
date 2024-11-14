package qa.Tests;

public class Testcase3 {
    public static void main(String[] args) {
        String originalString="Hello Bhai";
        String reverseString = new StringBuilder(originalString).reverse().toString();
        System.out.println("Original:"+originalString);
        System.out.println("Reversed:"+reverseString);
    }


}
