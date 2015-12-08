package test.service;

import test.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
