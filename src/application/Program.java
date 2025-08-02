package application;

import java.util.*;

public class Program {
	public static void main(String[] args) {
		Set<Integer> numbersInTreeSet = new TreeSet<>();
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("add three numbers: ");
			for (int i = 0; i < 3; i++) {
				int number = sc.nextInt();
				numbersInTreeSet.add(number);
			}
			
			System.out.println("The numbers in ascending order: " + numbersInTreeSet);
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}