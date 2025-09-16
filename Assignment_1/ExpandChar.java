/*
Assignment Title: Java Programming Assignment
Task 1: Expand Characters in a String
Owner class :- Abhay 
Date :-  9/16/2025
*/

import java.util.*;
public class ExpandChar {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your data : ");
		String input = sc.nextLine();
		/* edge case like :- 
		(i) ""
		(ii) "a"
		(iii) "1"
		(iv)  "1a"
		(v)   "a5"
		(vi)  "2e2a2n3i5"
		*/
			
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int freq = 0;
        while(i<input.length()){
            char ch = input.charAt(i);

            if(Character.isDigit(ch) && sb.isEmpty()){
                i++;
            }
           else if(sb.isEmpty()){
                sb.append(ch);
                i++;
            }
            else if(Character.isDigit(ch)){
                int value = Character.getNumericValue(ch);
                    freq = freq*10+value;
                    i++;
            }
            else if(!Character.isDigit(ch)){
                char temp = sb.charAt(sb.length()-1);
                for (int j = 1; j < freq; j++) {
                    sb.append(temp);
                }
                freq = 0;
                sb.append(ch);
                i++;
            }
            else{
                i++;
            }

        }
        if(freq > 0 && sb.length() > 0){
            char temp = sb.charAt(sb.length()-1);
            for (int j = 1; j < freq; j++) {
                sb.append(temp);
            }
        }
        System.out.println(sb.toString());
}
}