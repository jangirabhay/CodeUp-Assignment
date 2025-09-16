/*
Assignment Title: Java Programming Assignment
Task 2: Character Frequency in a String
Owner class :- Abhay 
Date :-  9/16/2025
*/

import java.util.*;

public class CharFreq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a data : ");
		String user = sc.nextLine();

		// String user = "aaaaaaaaaaaa";
		String answer = "";
		for (int i = 0; i < user.length(); i++) {
			int count = 0;
			char ch = user.charAt(i);
			answer += ch;
			for (int j = i; j < user.length(); j++) {
				if (ch == user.charAt(j)) {
					count++;
				} else {
					i = j - 1;
					break;
				}

				if (j == user.length() - 1) {
					i = j;
				}
			}
			answer += count;
		}
		System.out.println(answer);
	}

}