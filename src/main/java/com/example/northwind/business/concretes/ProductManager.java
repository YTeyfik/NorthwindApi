package com.example.northwind.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.corre.utilities.results.DataResult;
import com.example.northwind.corre.utilities.results.Result;
import com.example.northwind.corre.utilities.results.SuccessDataResult;
import com.example.northwind.corre.utilities.results.SuccessResult;
import com.example.northwind.dataAccess.abstracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;


@Service
public class ProductManager implements  ProductService{
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	
	
	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>
				(this.productDao.findAll(),"Data Listelendi.");
				
				
	}



	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data Listelendi.");
	}



	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi.");
	}



	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi.");
		
	}



	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi.");
		
	}



	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi.");
		
	}



	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi.");
		
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi.");
		
	}



	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent());
	}



	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort));
	}



	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data Listelendi.");
	}
	
	
}
