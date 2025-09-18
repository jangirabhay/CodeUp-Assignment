/*
Assignment Title: Java Programming Assignment  
Task 1: Expand Characters in a String  
Task 2: Character Frequency in a String
Task 3: Prime Number Checker 
Task 4: Number to Words Converter
Task 5: Longest Substring Without Repeating Characters

Class Owner : Abhay
Date : 17/9/2025
 */
import java.util.*;

public class MyString {

    public class StringSolution {
        public String[] ones = {
                "", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"
        };

        public String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };

        public boolean istrue(long value) { // check prime or not
            if (value <= 1) {
                return false;
            }
            for (int i = 2; (i * i) <= value; i++) {
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public String getfreq(String userInput) { // find the Char frequency
            String result = "";
            int i = 0;

            int count = 0;
            while (i < userInput.length()) {
                char ch = userInput.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    i++;
                } else if (result.isEmpty()) {
                    result += ch;
                    i++;
                } else if (ch == result.charAt(result.length() - 1)) {
                    count++;
                    i++;
                } else {
                    result = result + (count + 1);
                    count = 0;
                    result += ch;
                    i++;
                }

            }
            if (count >= 0) {
                result = result + (count + 1);
            }
            return result;
        }

        public String convertWord(int value) { // number to word
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

        public String expandCharacters(String input) { // To expand String
            String result = "";
            int i = 0;
            int count = 0;
            while (i < input.length()) {
                char ch = input.charAt(i);

                if (ch >= '0' && ch <= '9') {
                    if (result.isEmpty()) {

                        i++;
                    } else {

                        count = 0;
                        while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                            count = count * 10 + (input.charAt(i) - '0');
                            i++;
                        }

                        char temp = result.charAt(result.length() - 1);
                        for (int j = 1; j < count; j++) {
                            result = result + temp;
                        }
                        count = 0;
                    }
                } else {

                    result = result + ch;
                    i++;
                }
            }
            return result;
        }

        public int maxlen(String str) { // max lnegth of without repeating
            int maxLength = 0;
            int i = 0;
            int j = 0;

            while (j < str.length()) {
                String temp = str.substring(i, j + 1);

                if (checkDuplicates(temp)) {
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

        public boolean checkDuplicates(String temp) { // this part of upper method
			int i=0;
			int j=temp.length()-1;
			while(i<j){
					
					char ch1 = temp.charAt(i);
					char ch2 = temp.charAt(j);
					
					if(ch1 == ch2){
						return false;
					}
				else{
					i++;
				}
			}
            return true;
        }
    }

    public static void main(String[] args) {
        String taskdetail = """
                Task 1: Expand Characters in a String like :- [Input : a1b4c3 , Output : abbbbccc]
                Task 2: Character Frequency in a String like :- [Input : aabcccdeee , Output : a2b1c3d1e3]
                Task 3: Prime Number Checker like :- [Input : 21 , Output : The given number is NOT prime]
                Task 4: Number to Words Converter  like :- [Input :  51 , Output : fifty one]
                Task 5: Longest Substring Without Repeating Character like :- [Input : abcabcbb , Output : 3]
                """;
        System.out.println(taskdetail);
        Scanner userInput = new Scanner(System.in);
        
        MyString outer = new MyString();
        MyString.StringSolution inner = outer.new StringSolution();
		
		int number;
        while(true){
		System.out.print("Enter a number according to task : ");
        String choice = userInput.nextLine();
		try {
                    number  = Integer.parseInt(choice);
                    if (number > 0 && number <= 5) {
   						break;
                    } else {
                        System.out.println("Enter data in give range like (1 to 5) : ");
                    }
					

                } catch (NumberFormatException e) {
                    System.out.println("Enter valid number ");
                }
		
		}
		
		System.out.print("Enter your data according to given task example : ");
        switch (number) {
            case 1:
				String task1 = userInput.nextLine();
                System.out.println(inner.expandCharacters(task1));
                break;

            case 2:
				String task2 = userInput.nextLine();
                System.out.println(inner.getfreq(task2));
                break;

            case 3:
				long value;
				while (true) {
					System.out.print("Enter a number : ");
					String task3 = userInput.nextLine();
				try {
					value = Long.parseLong(task3);
						break; 
				} catch (NumberFormatException e) {
					System.out.println(" Please enter a valid integer.");
				}
			}

				if (inner.istrue(value)) {
					System.out.println("This is a prime number: " + value);
				} else {
					System.out.println("This is not a prime number: " + value);
				}

                break;
            case 4:
				int value1;
					while(true){
						String task4 = userInput.nextLine();
                try {
                    int data = Integer.parseInt(task4);
                    if (data > 0 && data <= 1000) {
                        value1 = data;
						break;
                    } else {
                        System.out.println("Enter data in give range like (1 to 1000) : ");
                    }
					

                } catch (NumberFormatException e) {
                    System.out.println("Enter valid number ");
                }
				
			}	
					System.out.print(inner.convertWord(value1));

                break;

            case 5:
				String task5 = userInput.nextLine();
                System.out.println(inner.maxlen(task5));
                break;

            default:
                System.out.println("Task is not there");

        }
    }

}
