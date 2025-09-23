/*
 * Assignment Title: Java Programming Assignment 
 * Tasks :- Based on String
 * Class Owner :-  Abhay
 * Date : 22/09/2025 
 */

import java.util.*;

public class MyString {

    public String merge(String str1, String str2) {
        String result = str1 + str2;
        return result;
    }

    public String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public String replace(String org, String rep, String put) {
        String result = "";
        String dummy = org;
        if (rep.length() == 1) {
            char temp = rep.charAt(0);
            for (int i = 0; i < dummy.length(); i++) {
                char ch = dummy.charAt(i);
                if (ch == temp) {
                    result += put;
                } else {
                    result += ch;
                }
            }
        } else {

            int i = 0;
            while (i <= dummy.length() - rep.length()) {
                String temp = dummy.substring(i, i + rep.length());
                if (rep.equals(temp)) {
                    result += put;
                    i += rep.length();
                } else {
                    result += dummy.charAt(i);
                    i++;
                }
            }

            while (i < dummy.length()) {
                result += dummy.charAt(i);
                i++;
            }
        }

        if (!result.isEmpty()) {
            org = result;
        }
        return org;
    }

    public String sort(String str) {
        int length = str.length();
        char[] words = new char[length];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            words[i] = ch;
        }

        mergeSort(words, 0, length - 1);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i];
        }
        return result;
    }

    public static void mergeSort(char[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // Sort left half
            mergeSort(arr, left, mid);
            // Sort right half
            mergeSort(arr, mid + 1, right);
            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(char[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        char[] leftArr = new char[n1];
        char[] rightArr = new char[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        MyString operations = new MyString();

        while (true) {
            String Tasks = """
                    Operations : -
                    1. -> Append  ex :- Hello  append(" World") result = Hello World
                    2. -> Replace(String a, String b)
                    3. -> Sort  ex : { program } after sort -> {agmnoprr}
                    4. -> Reverse  ex : {abcde}  after reverse -> {edcba}
                    5. -> Exit
                    """;
            System.out.println(Tasks);
            System.out.print("Select your operations : ");

            int choice;
            while (true) {
                String number = userInput.nextLine();
                try {
                    choice = Integer.parseInt(number);
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.print("Enter a number according to Operations : ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Enter valid number : ");
                }
            }
            if (choice == 5) {
                System.out.println("Thank you");
                break;
            }

            System.out.println("Enter a data according to given example : ");
            System.out.print("Enter a Word : ");
            String data = userInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter second word : ");
                    String second = userInput.nextLine();
                    System.out.print(operations.merge(data, second));
                    break;

                case 2:
                    if (data.isEmpty()) {
                        System.out.println("Your main data is empty");
                        break;
                    }

                    String remove;
                    System.out.println(
                            "Please enter a word that exactly matches part of the original data, including case (e.g., 'Ab' is valid in 'Abhay', but 'ab' is not).");

                    while (true) {

                        System.out.print("Enter remove  word : ");
                        String temp2 = userInput.nextLine();
                        if (data.length() >= temp2.length() && !temp2.isEmpty()) {
                            remove = temp2;
                            break;
                        } else {
                            System.out.println("Enter again :- ");
                        }
                    }
                    System.out.print("Enter replace word : ");
                    String replace = userInput.nextLine();
                    System.out.println(operations.replace(data, remove, replace));
                    break;

                case 3:
                    System.out.println(operations.sort(data));
                    break;

                case 4:
                    String task4 = userInput.nextLine();
                    System.out.println(operations.reverse(task4));
                    break;

                default:
                    System.out.println("Enter a number given range 1 to 5");

            }

            System.out.println("\n--------------------------------------------------------");
        }
    }
}
