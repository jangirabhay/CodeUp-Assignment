/*
 * Assignment Title: Java Program
 * tasks based on :- String & Number
 * Class owner = Abhay
 * Date : -  30/9/2025
 */

import java.util.*;

public class Operations {

    public long sumDigit(long num) {
        long result = 0;
        while (num != 0) {
            result += num % 10;
            num = num / 10;
        }
        return result;
    }

    public long countConsecutiveSumWays(long N) {
        long count = 0;
        for (long k = 1; k * (k - 1) / 2 < N; k++) {
            long numerator = N - k * (k - 1) / 2;
            if (numerator % k == 0) {
                count++;
            }
        }
        return count;
    }

    public char[] Encoded_ASCII_Transfor(char[] alpha, int series) {
        for (int i = 0; i < alpha.length; i++) {
            char ch = alpha[i];
            int value = (int) ch;
            value = value + series;
            alpha[i] = (char) value;
        }
        return alpha;
    }

    public String Caesar_Cipher_Encoding(String word, int shift) {
        int length = word.length();
        int lastchar = word.charAt(length - 1);
        int value = (int) lastchar + 1;
        String result = "";
        if (length == shift) {
            for (int i = value; i <= value + shift; i++) {
                char c = (char) i;
                result += c;
            }
        } else {
            int i = shift;
            while (i < length) {
                result += word.charAt(i);
                i++;
            }
            for (int j = 0; j < shift; j++) {
                char c = (char) value++;
                result += c;
            }
        }
        return result;
    }

    public String[] generateParentheses(int n) {
        String[] temp = new String[1000000];
        int[] count = new int[1];
        generate("", 0, 0, n, temp, count);
        String[] result = new String[count[0]];
        for (int i = 0; i < count[0]; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    private void generate(String current, int open, int close, int max, String[] temp, int[] count) {
        if (current.length() == 2 * max) {
            temp[count[0]] = current;
            count[0]++;
            return;
        }

        if (open < max) {
            generate(current + "(", open + 1, close, max, temp, count);
        }

        if (close < open) {
            generate(current + ")", open, close + 1, max, temp, count);
        }
    }

    public static void main(String[] args) {
        Operations tasks = new Operations();
        Scanner userInput = new Scanner(System.in);

        String detail = """
                    1. Valid Parenthesis Combination. ( input : 3, output : ["((()))","(()())","(())()","()(())","()()()"])
                    2. Sum of Digits (DigitSum). (input : 12345, output : 15)
                    3. Consecutive Number Sum. (input : 15, output : 4)
                    4. Caesar Cipher Encoding. (input : word = abc, shifted = 3 , output : def)
                    5. Encoded ASCII Transformation. (input : size = 4 data = {a,b,c,d}  series = 2 , output : c d e f
                    6. Exit..
                """;

        while (true) {
            System.out.println(detail);
            System.out.print("Select your operation : ");

            int choice;
            while (true) {
                String number = userInput.nextLine();
                try {
                    choice = Integer.parseInt(number);
                    if (choice >= 1 && choice <= 6) {
                        break;
                    } else {
                        System.out.print("Enter a number according to Operations : ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Enter valid number : ");
                }
            }

            if (choice == 6) {
                System.out.println("Thank you");
                break;
            }

            System.out.println("Enter a data according to given example : ");
            System.out.print("Enter a data : ");
            String data = userInput.nextLine();

            if (data.isEmpty()) {
                System.out.print("Your given data is Empty ");
                break;
            }

            switch (choice) {
                case 1:
                    int num;
                    try {
                        num = Integer.parseInt(data);
                        if (num >= 1 && num <= 13) {
                            String[] res = tasks.generateParentheses(num);
                            for (String s : res) {
                                System.out.print(s + " ");
                            }
                            System.out.println();
                        } else {
                            System.out.println("Enter a number in the range 1 to 13.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                    }
                    break;

                case 2:
                    try {
                        long number = Long.parseLong(data);
                        System.out.println(tasks.sumDigit(number));
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid number");
                    }
                    break;

                case 3:
                    try {
                        long number = Long.parseLong(data);
                        System.out.println(tasks.countConsecutiveSumWays(number));
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid number");
                    }
                    break;

                case 4:
                    System.out.print("Enter a shift number: ");
                    String value = userInput.nextLine();

                    try {
                        int shift = Integer.parseInt(value);
                        if (shift <= data.length() && shift >= 0) {
                            System.out.println(tasks.Caesar_Cipher_Encoding(data, shift));
                        } else {
                            System.out.println("Shift must be a non-negative number and your shifting length must less then data length");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter valid numeric data for the shift.");
                    }
                    break;

                case 5:
                    int size;
                    try {
                        size = Integer.parseInt(data);
                    } catch (Exception e) {
                        System.out.print("Enter valid data ");
                        break;
                    }

                    char[] alpha = new char[size];
                    String input;

                    while (true) {
                        System.out.println("Enter " + size + " characters (no spaces, e.g., abcde):");
                        input = userInput.nextLine();
                        if (input.length() >= size) {
                            for (int i = 0; i < size; i++) {
                                alpha[i] = input.charAt(i);
                            }
                            break;
                        } else {
                            System.out.println("Not enough characters entered! Please try again.");
                        }
                    }

                    int series;
                    while (true) {
                        System.out.println("Enter a number for the series:");
                        if (userInput.hasNextInt()) {
                            series = userInput.nextInt();
                            userInput.nextLine(); // clear buffer
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            userInput.nextLine(); // clear buffer
                        }
                    }

                    char[] result = tasks.Encoded_ASCII_Transfor(alpha, series);
                    for (char c : result) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("Task is not there");
            }

            System.out.println("\n-------------------------------------------");
        }
    }
}
