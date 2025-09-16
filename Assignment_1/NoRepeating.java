/*
Assignment Title: Java Programming Assignment
Task 5: Longest Substring Without Repeating Characters 
Owner class :- Abhay 
Date :-  9/16/2025
*/
import java.util.*;
public class NoRepeating{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();  // user input
        System.out.println(nonRepeating(str)); // function calling
    }
    public static int nonRepeating(String str){
            int length = 0;
            ArrayList<Character> list = new ArrayList<>(); // dynamic memory

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(list.contains(ch)){
                    length = Math.max(length, list.size());
                    list.clear(); // clean list 
                    list.add(ch);
                }
                else{
                    list.add(ch); // insert char value 
                }
            }
            return length;
}
}