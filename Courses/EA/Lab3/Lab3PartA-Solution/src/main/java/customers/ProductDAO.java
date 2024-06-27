package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void clearDB() {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        jdbcTemplate.update("DELETE from product",namedParameters);
        jdbcTemplate.update("DELETE from supplier",namedParameters);
    }

    public void save(Product product) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("prodNum", product.getProdNum());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES ( :prodNum, :name, :price)", namedParameters);

        Map<String, Object> supplierNamedParameters = new HashMap<String, Object>();
        supplierNamedParameters.put("productNumber", product.getProdNum());
        supplierNamedParameters.put("name", product.getSupplier().getName());
        supplierNamedParameters.put("phone", product.getSupplier().getPhone());
        jdbcTemplate.update("INSERT INTO supplier VALUES ( :phone, :name, :productNumber)", supplierNamedParameters);
    }

    public Product findByProductNumber(String prodNum) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("prodNum", prodNum);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "prodNum =:prodNum ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getString("prodNum"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        Supplier supplier = getSupplierOfProduct(product.getProdNum());
        product.setSupplier(supplier);
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product( rs.getString("prodNum"),
                        rs.getString("name"),
                        rs.getDouble("price")));

        for (Product product : products) {
            Supplier supplier = getSupplierOfProduct(product.getProdNum());
            product.setSupplier(supplier);
        }
        return products;
    }

    public Product findByProductName(String productName) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productName", productName);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "name =:productName ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getString("prodNum"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        Supplier supplier = getSupplierOfProduct(product.getProdNum());
        product.setSupplier(supplier);
        return product;
    }

    public void removeProduct(String productNumber) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("prodNum", productNumber);
        jdbcTemplate.update("DELETE from product WHERE "
                + "prodNum =:prodNum",namedParameters);

        Map<String,Object> supplierNamedParameters = new HashMap<String,Object>();
        supplierNamedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE from supplier WHERE "
                + "productNumber =:productNumber",supplierNamedParameters);

    }


    Supplier getSupplierOfProduct(String productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier( rs.getString("name"),
                        rs.getString("phone")));

        return supplier;
    }

}
