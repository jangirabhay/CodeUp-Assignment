/*
Assignment Title: Java Programming Assignment
Task 3: Prime Number Checker
Owner class :- Abhay 
Date :-  9/16/2025
*/
import java.util.*;
public class PrimeCheck{
	public static boolean istrue(int value){
		if(value <= 1){
			return false;
		}
		for(int i=2; i<value; i++){
			if(value%i == 0){
				return false;
			}
	}
	return true;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter a number : ");
			String input = sc.nextLine(); // user input 
			try{
				int number = Integer.parseInt(input); // convert into integer
				
					if(istrue(number)){
						System.out.println("this is prime number " + number);
				}	else{
					System.out.println("this is not prime number " + number);
				}
				
				
			} catch (NumberFormatException e) { // any issue face while converting string to integer this conditions execute
            System.out.println("Please enter a valid number.");
        }				
	}
	
}