public class Task5 {
    public static int binaryDeci(int binary){
        int decimal = 0;
        int base = 1;  // 2^0

        while (binary > 0) {
            int lastDigit = binary % 10;
            decimal += lastDigit * base;
            base *= 2;
            binary /= 10;
        }
        return decimal;
    }
    public static void main(String[] args) {
        int binary = 110;
        System.out.println(binaryDeci(binary));

        
    }
}
