
/*
Assignment Title: ->  Java Programming Assignment  <-    
Task 1: Expand Characters in a String  
Task 2: Character Frequency in a String
Task 3: Prime Number Checker 
Task 4: Number to Words Converter
Task 5: Longest Substring Without Repeating Characters

Class Owner : Abhay
Date : 17/9/2025
 */
import java.util.*;

public class AdditionQuiz {
    static String[] ones = {
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    static String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static void main(String[] args) {
        System.out.println();
		String taskDetail = """
							Task 1: Expand Characters in a String ex. :-  [Input : a1b4c3 , Output : abbbbccc],
							Task 2: Character Frequency in a String ex. :-  [Input : aabcccdeee , Output : a2b1c3d1e3],
							Task 3: Prime Number Checker ex. :-  [Input : 21 , Output : The given number is NOT prime],
							Task 4: Number to Words Converter ex. :- [Input :  51 , Output : fifty one],
							Task 5: Longest Substring Without Repeating Character ex :- [Input : abcabcbb , Output : 3], """;
							System.out.print(taskDetail);   
		
		
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter a number according to task : ");
        int number = sc.nextInt();
		sc.nextLine();
        switch (number) {
            case 1:
                System.out.print("Enter a data: ");
                String task1 = sc.nextLine();
                System.out.println(task1 + " -> " + expandCharacters(task1));
                break;

            case 2:
                System.out.print("Enter a data : ");
                String task2 = sc.nextLine();
                System.out.println(task2 + " -> " + getfreq(task2));
                break;

            case 3:
                System.out.print("Enter a number: ");

                if (sc.hasNextInt()) {
                    int task3 = sc.nextInt();

                    if (isTrue(task3)) {
                        System.out.println("This is a prime number: " + task3);
                    } else {
                        System.out.println("This is not a prime number: " + task3);
                    }

                } else {
                    System.out.println("Please enter a valid number.");
                }
                break;
            case 4:
                System.out.print("Enter a number between (1 -> 1000) : ");
                if (sc.hasNextInt()) {
                    int task4 = sc.nextInt();
                    System.out.println( task4 + " -> " + inStrng(task4));

                } else {
                    System.out.println("Please enter a valid number.");
                }

                break;

            case 5:

                System.out.print("Enter your data : ");
                String task5 = sc.nextLine();
                System.out.println(task5 + " -> " + maxlen(task5));
                break;

            default:
                System.out.println("Task is not there");
                break;
        }
    }

    public static String expandCharacters(String input) { // To expand String
        String ans = "";
        int i = 0;
        int count = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);

            if (ch >= '0' && ch <= '9') {
                if (ans.isEmpty()) {

                    i++;
                } else {

                    count = 0;
                    while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                        count = count * 10 + (input.charAt(i) - '0');
                        i++;
                    }

                    char temp = ans.charAt(ans.length() - 1);
                    for (int j = 1; j < count; j++) {
                        ans = ans + temp;
                    }
                    count = 0;
                }
            } else {

                ans = ans + ch;
                i++;
            }
        }
        return ans;
    }

    public static String getfreq(String userInput) { // find the Char frequency
        String answer = "";
        int i = 0;

        int count = 0;
        while (i < userInput.length()) {
            char ch = userInput.charAt(i);
            if (ch >= '0' && ch <= '9') {
                i++;
            } else if (answer.isEmpty()) {
                answer += ch;
                i++;
            } else if (ch == answer.charAt(answer.length() - 1)) {
                count++;
                i++;
            } else {
                answer = answer + (count + 1);
                count = 0;
                answer += ch;
                i++;
            }

        }
        if (count >= 0) {
            answer = answer + (count + 1);
        }
        return answer;
    }

    public static boolean isTrue(int value) { // check prime or not
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String inStrng(int value) { // number to String
        if (value == 1) {
            return "One";
        }
        if (value == 1000) {
            return "One Thousand";
        }
        String word = "";
        if (value >= 100) {
            int hundred = value / 100;
            word = word + (ones[hundred]);
            word = word + " Hundred";
            value = value % 100;
            if (value != 0) {
                word = word + " ";
            }
        }
        if (value >= 20) {
            int ten = value / 10;
            int unit = value % 10;
            word = word + (tens[ten]);
            if (unit != 0) {
                word = word + " ";
                word = word + (ones[unit]);
            }
        } else if (value > 0) {
            word = word + (ones[value]);
        }

        return word;
    }

    public static int maxlen(String str) { // max lnegth of without repeating
        int maxLength = 0;
        int i = 0;
        int j = 0;

        while (j < str.length()) {
            String temp = str.substring(i, j + 1);

            if (checkNoDuplicates(temp)) {
                if (maxLength < temp.length()) {
                    maxLength = temp.length();
                    j++;
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }

        return maxLength;
    }

    public static boolean checkNoDuplicates(String temp) {
        boolean[] seen = new boolean[26];

        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if (seen[ch - 'a']) {
                return false;
            }
            seen[ch - 'a'] = true;
        }

        return true;
    }
}
