package xyz.pakwo.dashboard.service;

import org.springframework.stereotype.Service;
import xyz.pakwo.dashboard.model.ProductDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author sarwo.wibowo
 **/
@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public List<ProductDto> getProducts() {
        //should get from repository layer
        ProductDto product1 = createProduct(1L);
        ProductDto product2 = createProduct(2L);
        ProductDto product3 = createProduct(3L);
    return Arrays.asList(product1, product2, product3);
    }

    @Override
    public ProductDto getById(Long id) {
        List<ProductDto> products = getProducts();
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    private ProductDto createProduct(long id) {
        return ProductDto.builder().id(id).code("code-" + id).sku("sku-" + 1).description("Product description " + id).build();
    }
}
