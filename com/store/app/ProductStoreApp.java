package com.store.app;

import static com.store.util.ProductUtil.addNewProduct;
import static com.store.util.ProductUtil.checkDuplicateProductCode;
import static com.store.util.ProductUtil.loadExistingProductList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.store.model.Category;
import com.store.model.Product;

public class ProductStoreApp {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in);
				BufferedReader brRead = new BufferedReader(new InputStreamReader(System.in))) {
			
			List<Product> productList = loadExistingProductList();
			
			System.out.println("######################################");
			System.out.println("#######WELCOME TO CARTANA STORE#########");
			System.out.println("######################################");			
			int flag = 0;
			
			while(flag==0) {
				System.out.println("##Type:- 1 to Add a New Product##");
				System.out.println("##Type:- 2 to Search By All Product List##");
				System.out.println("##Type:- 3 to Search a Product by item_code or item_name##");
				System.out.println("##Type:- 4 to list all the products##");
				System.out.println("##Type:- 5 Exit##");
				System.out.println("##Enter your choice: ##");
				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("#Enter the Item code:# ");
					String itemCode = brRead.readLine();
					checkDuplicateProductCode(itemCode, productList);
					System.out.println("#Enter Item name: #");
					String itemName = brRead.readLine();
					System.out.println("#Enter the Buing price: #");
					double buyingPrice = scan.nextDouble();
					System.out.println("#Enter the Selling price: #");
					double sellingPrice = scan.nextDouble();
					System.out.println("#Enter product category: #");
					String category = brRead.readLine().toUpperCase();
					System.out.println("#Enter Tax input: #");
					double tax = scan.nextDouble();
					System.out.println("#Enter Quantity: #");
					int quantity = scan.nextInt();
					
					productList.add(addNewProduct(itemCode, itemName, buyingPrice, sellingPrice, category, tax, quantity));

					break;

				case 2:
					System.out.println("#Enter the category you need to search for: #");
					String searchCategory = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getCategory() == Category.valueOf(searchCategory)) {
							System.out.println(product);
						} 
					}
					break;
					
				case 3:
					System.out.println("#Enter product name or product code that you want to search: #");
					String search = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getItemCode().equals(search) || product.getItemName().toUpperCase().equals(search)) {
							System.out.println("Product found!!!");
							System.out.println(product);
						}
					}
					break;
					
				case 4:
					for (Product product : productList) {
						System.out.println(product);
					}
					break;
					
				case 5:
					flag = 1;
					System.out.println("##Good Bye##");
					System.exit(0);
					break;
					
				default:
					System.out.println("Not a valid choice");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
