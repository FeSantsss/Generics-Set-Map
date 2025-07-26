package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter the number of products: ");
			int n = sc.nextInt();
			List<Product> products = new ArrayList<>(n);
			
			for (int i = 0; i < n; i++) {
				sc.nextLine();
				System.out.printf("Product #%d data:\n", i + 1);
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Quantity: ");
				int quantity = sc.nextInt();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				
				products.add(new Product(name, quantity, price));
			}
			
			System.out.print("\nWhich product do you want to add stock to? ");
			sc.nextLine();
			String productName = sc.nextLine();
			try {
				System.out.print("Enter the quantity to add: ");
				int quantityToAdd = sc.nextInt();
				for (Product product : products) {
					boolean found = false;
					if (productName.equals(product.getName())) {
						product.addStock(quantityToAdd);
						System.out.println("\nStock updated successfully.");
						found = true;
						break;
					} if (found == false) {
						System.out.println("Product not found.");
					}
				}
			}catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			System.out.println("\nProducts entered:");
			System.out.println("\nProducts order:");
			Collections.sort(products);
			
			for (Product product : products) {
				System.out.println(product);
			}
			
			double totalValue = 0.0;
			for (Product product : products) {
				totalValue += product.totalValue();
			}
			System.out.printf("\nTotal value in stock: %.2f\n", totalValue);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}