package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.*;

public class Main {
	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println("Product data #" + (i + 1));
			
			System.out.print("-> Common, used or imported (c/u/i): ");
			char resp = sc.next().charAt(0);
			resp = Character.toLowerCase(resp);
			
			System.out.print("-> Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("-> Product price: ");
			double price = sc.nextDouble();
			
			if(resp == 'i') {
				System.out.print("-> Custom fees: ");
				double customFees = sc.nextDouble();
				productList.add(new ImportedProduct(name, price, customFees));
			} else if(resp == 'u') {
				System.out.print("-> Manufacture date (yyyy-MM-dd): ");
				sc.nextLine();
				LocalDate date = LocalDate.parse(sc.nextLine());
				productList.add(new UsedProduct(name, price, date));
			}else
				productList.add(new Product(name, price));
			System.out.println();
		}
		
		for(Product x : productList)
			System.out.println(x.priceTag());
		
		sc.close();
	}

}
