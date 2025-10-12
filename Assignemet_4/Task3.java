public class Task3 {
    public String camelConver(String str) {
        int n = str.length();
        String result = "";
        int i = 0;
        while (i < n) {
            char ch = str.charAt(i);
            if (ch == '_' && i == n - 1) {
                i++;
            }

            if (ch == '_') {
                char target = str.charAt(i+1);
                result = result + Character.toUpperCase(target);
                i=i+2;
            } else {
                result = result + ch;
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Task3 task = new Task3();
        String str = "hello_word_java";
        String result = task.camelConver(str);
        System.out.println(result);
    }
}
