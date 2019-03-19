package com.cg.product.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.product.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

}
