package com.cg.product.services;
import java.util.List;

import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductNotFoundException;
public interface ProductServices {
	Product createProductDetails(Product product);
	Product getProductDetails(int productId) throws ProductNotFoundException;
	public boolean updateProduct(int productId, Product product) throws ProductNotFoundException;
	List<Product>getAllProductDetails() throws ProductNotFoundException;
	boolean deleteProductDetails (int productId) throws ProductNotFoundException;

}
