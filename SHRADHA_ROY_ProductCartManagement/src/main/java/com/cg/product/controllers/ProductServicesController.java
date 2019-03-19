package com.cg.product.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductNotFoundException;
import com.cg.product.services.ProductServices;
@Controller
public class ProductServicesController {
	@Autowired
	ProductServices services;
	@RequestMapping(value= {"/createProductDetails"},method=RequestMethod.POST,
			produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>createProductDetails(@ModelAttribute Product product){
		product=services.createProductDetails(product);
		return new ResponseEntity<>("Product Details successfully added Product Id:-"+product.getProductId(),HttpStatus.OK);
	}
	@RequestMapping(value= {"/getProductDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Product>getProductDetails(@RequestParam int ProductId) throws ProductNotFoundException{
		Product product=services.getProductDetails(ProductId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	@RequestMapping(value= {"/getAllProductDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Product>>getAllProductDetails() throws ProductNotFoundException{
		return new ResponseEntity<List<Product>>(services.getAllProductDetails(),HttpStatus.OK);
	}
	@RequestMapping(value={"/updateProductDetails"},method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json") 
	  public ResponseEntity<Boolean>updateProductDetailsRequestPathParam(@RequestParam int ProductId,@ModelAttribute Product product)
			  throws ProductNotFoundException {
	      boolean updateStatus = services.updateProduct(ProductId, product);
	  return new ResponseEntity<Boolean>(updateStatus,HttpStatus.OK); 
	  }
	
	@RequestMapping(value= {"/deleteProductDetails"},method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>deleteProductDetails(@RequestParam int ProductId) throws ProductNotFoundException{
		services.deleteProductDetails(ProductId);
		return new ResponseEntity<>("Product Details successfully removed:-",HttpStatus.OK);
	
	}

}
