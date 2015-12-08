package test.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import test.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products =
			new HashMap<Long, Product>();
	
	private AtomicLong generator = new AtomicLong();
	
	public ProductServiceImpl() {
		Product product = new Product();
		product.setName("JX1 Power Drill");
		product.setDescription("Power full hand drill");
		product.setPrice(129.99F);
		add(product);
	}
	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		
		Long newId = generator.incrementAndGet();
		product.setId(newId);
		products.put(newId, product);
		return product;
	}

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return products.get(id);
	}

}
