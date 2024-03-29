package com.example.northwind.business.abstracts;

import java.util.List;

import com.example.northwind.corre.utilities.results.DataResult;
import com.example.northwind.corre.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
    DataResult<List<Product>>  getAll();
    DataResult<List<Product>>  getAllSorted();
    DataResult<List<Product>>  getAll(int pageNo,int pageSize);//Pagination
    
    Result add(Product product);
    
    DataResult<Product> getByProductName(String productName);
	
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
    DataResult<List<Product>> getByProductNameContains(String productName);
	
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
    
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
