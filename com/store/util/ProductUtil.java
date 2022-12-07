package com.store.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.store.exception.ProductCustomException;
import com.store.model.Category;
import com.store.model.Product;

public class ProductUtil {

	
	public static Product addNewProduct(String itemCode, String itemName,
			double buyingPrice, double sellingPrice, String category,
			double tax, int quantity) throws ProductCustomException, ParseException {
		validateBuyingPrice(buyingPrice);
		validateSellingPrice(sellingPrice, buyingPrice);
		Category checkCategory = validateCategory(category);
		return new Product(itemCode, itemName, buyingPrice, sellingPrice, checkCategory, tax, quantity);
	}

	public static List<Product> loadExistingProductList() throws ParseException {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("1", "Asus", 45000, 55000, Category.LAPTOP, 18, 5));
		productList.add(new Product("3", "Sonata", 800, 1800, Category.WATCH, 20, 50));
		productList.add(new Product("4", "Canon", 50000, 65000, Category.CAMERA, 30, 25));
		
		return productList;
	}
	public static void checkDuplicateProductCode(String itemCode,
			List<Product> productList) throws ProductCustomException {
			Product checkProduct = new Product(itemCode);
			for (Product product : productList) {
				if (product.equals(checkProduct)) {
					throw new ProductCustomException("#Duplicate product found!#");
					
				}
			}
		}

		public static void validateBuyingPrice(double buyingPrice)
				throws ProductCustomException {
			if (buyingPrice <= 0) {
				throw new ProductCustomException(
						"Buying price has to be greater than 0!!!");
			}
		}
			public static void validateSellingPrice(double sellingPrice, double buyingPrice)
					throws ProductCustomException {
				if (sellingPrice < buyingPrice) {
					throw new ProductCustomException(
							"Selling price can't be less than buying price!!!");
				}
			}		public static Category validateCategory(String category) throws ParseException {
				Category checkCategory = Category.valueOf(category);
				return checkCategory;
			}
			
}
