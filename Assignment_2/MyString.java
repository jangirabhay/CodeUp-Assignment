/*
Assignment Title: Java Programming Assignment
Tasks :- Based on String
		1.append(String newString)
  		2. replace(String a, String b)
		3. sort()
		4. reverse()
Class owner : Abhay
Date : - 19/09/2025
*/
import java.util.*;

public class MyString {
    public class Solution {
        public String mergeWord(String str1, String str2) {
            String result = str1 + str2;
            return result;
        }

        public String replaceWord(String org, String rep, String tar) {
            String result = "";
            String dummy = org;
            if (rep.length() == 1) {
                char temp = rep.charAt(0);
                for (int i = 0; i < dummy.length(); i++) {
                    char ch = dummy.charAt(i);
                    if (ch == temp) {
                        result += tar;
                    } else {
                        result += ch;
                    }
                }
            } else {

                int i = 0;
                while (i <= dummy.length() - rep.length()) {
                    String temp = dummy.substring(i, i + rep.length());
                    if (rep.equals(temp)) {
                        result += tar;
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

        public String sortWord(String str) {
            char[] word = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                word[i] = ch;
            }

            quickSort(word, 0, word.length - 1);
            String result = "";
            for (int i = 0; i < word.length; i++) {
                result += word[i];
            }
            return result;
        }

        public String reverse(String str) {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        }

        public void quickSort(char[] word, int start, int end) {
            if (start < end) {
                int pivot = partitions(word, start, end);
                quickSort(word, start, pivot - 1);
                quickSort(word, pivot + 1, end);
            }
        }

        public int partitions(char[] word, int start, int end) {
            int index = start - 1;
            char pivot = word[end];

            for (int i = start; i < end; i++) {
                char currentCharLower = Character.toLowerCase(word[i]);
                char pivotLower = Character.toLowerCase(pivot);

                if (currentCharLower < pivotLower
                        || (currentCharLower == pivotLower && word[i] < pivot)) {
                    index++;
                    char temp = word[i];
                    word[i] = word[index];
                    word[index] = temp;
                }
            }

            index++;
            char temp = word[index];
            word[index] = word[end];
            word[end] = temp;
            return index;
        }
    }

    public static void main(String[] args) {
        String Tasks = """
                Operations : -
                1. -> Append  ex :- Hello  append(" World") result = Hello World
                2. ->  replace(String a, String b)
                3. -> sort  ex : { program } after sort -> {agmnoprr}
                4. -> Reverse  ex : {abcde}  after reverse -> {edcba}
                """;
        System.out.println(Tasks);
        System.out.print("Enter a operation number which you want  : ");
        Scanner userinput = new Scanner(System.in);
        int choice;
        while (true) {
            String number = userinput.nextLine();
            try {
                choice = Integer.parseInt(number);
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.print("Enter a number according to task : ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Enter valid number : ");
            }
        }

        MyString outer = new MyString();
        MyString.Solution inner = outer.new Solution();
        System.out.println("Enter a data according to given example : ");

        switch (choice) {
            case 1:
                System.out.print("Enter first word : ");
                String first = userinput.nextLine();
                System.out.print("Enter second word : ");
                String second = userinput.nextLine();
                System.out.print(inner.mergeWord(first, second));
                break;

            case 2:
                String orginal;
                String remove;
                
                while (true) {
                    System.out.print("Enter a orginal Word : ");
                    String temp1 = userinput.nextLine();
                    System.out.print("Enter remove  word : ");
                    String temp2 = userinput.nextLine();
                    if (temp1.length() >= temp2.length()) {
                        orginal = temp1;
                        remove = temp2;
                        break;
                    } else {
                        System.out.println("Your givem data is wrong please enter again ");
                    }
                }
				System.out.print("Enter replace word : ");
                String replace = userinput.nextLine();
                System.out.println(inner.replaceWord(orginal, remove, replace));
                break;

            case 3:
                while (true) {
                    String temp = userinput.nextLine();
                    int i = 0;
                    while (i < temp.length()) {
                        char ch = temp.charAt(i);
                        if (!Character.isLetter(ch)) {
                            break;
                        } else {
                            i++;
                        }
                    }

                    if (i == temp.length()) {
                        System.out.print(inner.sortWord(temp));
                        break;
                    } else {
                        System.out.print("Enter valid data : ");
                    }
                }

                break;

            case 4:
                String task4 = userinput.nextLine();
                System.out.println(inner.reverse(task4));
                break;
            default:
                break;
        }
    }

}


