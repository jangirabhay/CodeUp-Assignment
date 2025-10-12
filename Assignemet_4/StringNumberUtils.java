/*
 Assignment Title: Java Menu-Driven Program – String & Number Operations
 Operations to Implement
  -> 1. Count Unique Palindromes (Input: "ababa", Output: 3 (palindromes → "aba", "bab", "ababa"))
  -> 2. Fibonacci Sequence – Nth Number (Input: 6, Output: 8)
  -> 3. Snake Case to Camel Case Conversion (Input: "hello_world_java",Output: "helloWorldJava")
  -> 4. Count Consonants in a String (Input: "hello world", Output: 7)
  -> 5. Binary to Decimal Conversion (Input: "1011", Output: 11)

  class owner : Abhay
  Date : 7/10/2025
*/

import java.util.*;

public class StringNumberUtils {

  // 1. Count Unique Palindromes
  public Set<String> uniquePalindromes(String str) {
    Set<String> unique = new HashSet<>();
    int length = str.length();

    for (int i = 0; i < length; i++) {
      for (int j = i + 2; j <= length; j++) {
        String temp = str.substring(i, j);
        if (isPalindrome(temp)) {
          unique.add(temp);
        }
      }
    }
    return unique;
  }

  public boolean isPalindrome(String str) {
    int i = 0, j = str.length() - 1;
    while (i < j) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  // 2. Fibonacci Sequence – Nth Number 
  public int fibSeq(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int a = 0, b = 1, c = 0;
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  // 3. Snake Case to Camel Case Conversion
  public String snakeToCamel(String str) {
    StringBuilder result = new StringBuilder();
    boolean toUpper = false;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '_') {
        toUpper = true;
      } else {
        result.append(toUpper ? Character.toUpperCase(ch) : ch);
        toUpper = false;
      }
    }
    return result.toString();
  }

  // 4. Count Consonants in a String
  public int countConsonants(String user) {
    int count = 0;
    for (int i = 0; i < user.length(); i++) {
      char ch = user.charAt(i);
      if (Character.isLetter(ch)) {
        char lower = Character.toLowerCase(ch);
        if ("aeiou".indexOf(lower) == -1) {
          count++;
        }
      }
    }
    return count;
  }

  // 5. Binary to Decimal Conversion
  public int binaryToDecimal(int binary) {
    int decimal = 0;
    int base = 1;

    while (binary > 0) {
      int lastDigit = binary % 10;
      decimal += lastDigit * base;
      base *= 2;
      binary /= 10;
    }
    return decimal;
  }

  // MAIN MENU-DRIVEN LOGIC
  public static void main(String[] args) {
    StringNumberUtils operations = new StringNumberUtils();
    Scanner userInput = new Scanner(System.in);

    String menu = """
        \n==== JAVA STRING & NUMBER OPERATIONS ====
        1. Count Unique Palindromes
        2. Fibonacci Sequence – Nth Number
        3. Snake Case to Camel Case Conversion
        4. Count Consonants in a String
        5. Binary to Decimal Conversion
        6. Exit
        =========================================
        """;

    while (true) {
      System.out.println(menu);
      System.out.print("Select your operation (1-6): ");

      int choice;
      while (true) {
        String number = userInput.nextLine();
        try {
          choice = Integer.parseInt(number);
          if (choice >= 1 && choice <= 6) {
            break;
          } else {
            System.out.print("Enter a number between 1 and 6: ");
          }
        } catch (NumberFormatException e) {
          System.out.print("Enter a valid number: ");
        }
      }

      if (choice == 6) {
        System.out.println("Exiting the program. Thank you!");
        break;
      }

      System.out.print("Enter input data: ");
      String data = userInput.nextLine().trim();

      switch (choice) {
        case 1 -> {
          Set<String> palindromes = operations.uniquePalindromes(data);
          System.out.println("Unique Palindromes Found:");
          for (String p : palindromes) {
            System.out.print(p+" ");
          }
          System.out.println("\nTotal Count: " + palindromes.size());
        }

        case 2 -> {
          try {
            int num = Integer.parseInt(data);
            if (num < 0) {
              System.out.println("Fibonacci index must be non-negative.");
            } else {
              System.out.println("Fibonacci(" + num + ") = " + operations.fibSeq(num));
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
          }
        }

        case 3 -> {
          System.out.println("CamelCase: " + operations.snakeToCamel(data));
        }

        case 4 -> {
          System.out.println("Total Consonants: " + operations.countConsonants(data));
        }

        case 5 -> {
          if (!data.matches("[01]+")) {
            System.out.println("Please enter a valid binary number (only 0s and 1s).");
          } else {
            try {
              int binary = Integer.parseInt(data);
              int decimal = operations.binaryToDecimal(binary);
              System.out.println("Decimal Value: " + decimal);
            } catch (NumberFormatException e) {
              System.out.println("Binary number too large to convert.");
            }
          }
        }

        default -> {
          System.out.println("Invalid choice. Please select from 1 to 6.");
        }
      }

      System.out.println("\n------------------------------------------");
    }

    userInput.close();
  }
}
