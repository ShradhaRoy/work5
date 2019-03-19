package com.cg.product.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.product.beans.Product;
import com.cg.product.daoservices.ProductDao;
import com.cg.product.exceptions.ProductNotFoundException;
@Component("ProductServices")
public class ProductServicesImpl implements ProductServices{
	@Autowired
	private ProductDao productDao;

	@Override
	public Product createProductDetails(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product getProductDetails(int productId) throws ProductNotFoundException {
		Product prod=null;
		prod=productDao.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
		return prod;
	}

	@Override
	public List<Product> getAllProductDetails() throws ProductNotFoundException{
		List<Product> prod=productDao.findAll();
		return prod;
	}

	@Override
	public boolean deleteProductDetails(int productId) throws ProductNotFoundException {
		productDao.delete(getProductDetails(productId));
		return true;
	}

	@Override
	public boolean updateProduct(int productId, Product product) throws ProductNotFoundException{
		createProductDetails(product);
		product.setProductId(productId);
		productDao.save(product);
		return true;
	}

}
