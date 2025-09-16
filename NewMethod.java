/*
Assignemnt_Task:-0 :-  Print the table of a given number
Owner class :- Abhay 
Date :-  9/15/2025
*/


import java.util.*;

public class NewMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        System.out.print("Enter a table number: ");
        String input = sc.nextLine();
        System.out.print("Enter a range : ");
        String range = sc.nextLine();

        try {
            int number = Integer.parseInt(input);
            int end = Integer.parseInt(range);
            if (number > 0 && end > 0) {
                for (int i = 1; i <= end; i++) {
                    System.out.println(number + " * " + i + " = " + number * i);
                }
            } else {
                System.out.println("Enter only positive number");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }

    }
}
