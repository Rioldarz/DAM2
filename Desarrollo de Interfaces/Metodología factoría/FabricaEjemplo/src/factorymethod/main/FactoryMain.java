package factorymethod.main;

import java.sql.SQLException;
import java.util.List;

import factorymethod.dao.ProductDAO;
import factorymethod.entity.Product;

public class FactoryMain {
	public static void main(String[] args) throws SQLException {
		Product productA = new Product(7L, "Producto F", 100);
		Product productB = new Product(8L, "Producto G", 100);

		ProductDAO productDAO = new ProductDAO();

		productDAO.saveProduct(productA);
		productDAO.saveProduct(productB);

		List<Product> products = productDAO.findAllProducts();
		System.out.println("Product size ==> " + products.size());
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
