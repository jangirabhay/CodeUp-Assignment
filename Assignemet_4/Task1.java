public class Task1 {
        String[] store;
    public int  uniquePalind(String str) {
        int count = 0;
        int length = str.length();
         store = new String[length * length];  
        int index = 0;  

        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j++) {
                String temp = str.substring(i, j);
                if (ispalindromes(temp) && !contains(store, index, temp)) {
                    store[index] = temp;  
                    index++;              
                    count++;
                }
            }
        }
        return count;
    }

    public boolean contains(String[] store, int size, String target) {
        for (int i = 0; i < size; i++) {
            if (store[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean ispalindromes(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        String str = "ababa";
        int result = task.uniquePalind(str);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(task.store[i] + " ");
        }
    }
}
