package xyz.pakwo.dashboard.service;

import xyz.pakwo.dashboard.model.ProductDto;

import java.util.List;
import java.util.Map;

/**
 * @author sarwo.wibowo
 **/
public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto getById(Long id);

    Map<String, Object> getMatrix();
}
