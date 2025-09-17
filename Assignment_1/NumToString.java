/*
Assignment Title: Java Programming Assignment
Task 4: Number to Words Converter  
Owner class :- Abhay 
Date :-  9/16/2025
*/
import java.util.*;
public class NumToString{
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

    public static void printString(int value) {
		int orignal = value;
        if (value == 0) {
            System.out.println(orignal + " -> " + "Zero");
            return;
        }

        if (value == 1000) {
            System.out.println(orignal + " -> " + "One Thousand");
            return;
        }

        StringBuilder word = new StringBuilder();

        if (value >= 100) {
            int hundred = value / 100;
            word.append(ones[hundred]);
            word.append(" Hundred");
            value = value % 100;
            if (value != 0) {
                word.append(" ");
            }
        }

        if (value >= 20) {
            int ten = value / 10;
            int unit = value % 10;

            word.append(tens[ten]);
            if (unit != 0) {
                word.append(" ");
                word.append(ones[unit]);
            }
        } else if (value > 0) {
            word.append(ones[value]);
        }

        System.out.println(orignal + " -> " + word);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between (1 -> 1000):");
        String input = sc.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (number >= 1 && number <= 1000) {
                printString(number);
            } else {
                System.out.println("Enter a number between 1 and 1000.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number.");
        }
    }

}
