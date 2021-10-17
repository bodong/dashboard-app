package xyz.pakwo.dashboard.model;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sarwo.wibowo
 **/
@Getter
@Builder
public class ProductDto {
    private Long id;
    private String sku;
    private String code;
    private String description;
}
