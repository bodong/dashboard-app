package xyz.pakwo.dashboard.service;

import org.openjdk.jol.info.GraphLayout;
import org.springframework.stereotype.Service;
import xyz.pakwo.dashboard.model.ProductDto;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** @author sarwo.wibowo */
@Service
public class ProductServiceImpl implements ProductService {

  @Override
  public List<ProductDto> getProducts() {
    // should get from repository layxer
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

  @Override
  public Map<String, Object> getMatrix() {

    Map<String, Object> matrix = new ConcurrentHashMap<>();
    matrix.put("numberGet", 10000); //just for simplicity
    matrix.put("numberPost", 3000);
    matrix.put("numberDelete", 2000);

    long totalMessage = getDummyMessageSize();

    matrix.put("dataSize", totalMessage);
    matrix.put("dataSizePretty", formatSize(totalMessage));


    return matrix;
  }

  private long getDummyMessageSize() {
    Map<String, Object> data = new ConcurrentHashMap<>();

    String str = "";
    for (int i = 0; i < 1000; i++) {
      str += "Lorem ipsum again again again";
    }
    data.put("msg1", str);
    data.put("msg2", 1233);
    data.put("msg3", "OK");

    long size = GraphLayout.parseInstance(data).totalSize();
    return size;
  }

  private static String formatSize(long sizeData) {
    long absB = sizeData == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(sizeData);
    if (absB < 1024) {
      return sizeData + " B";
    }
    long value = absB;
    CharacterIterator ci = new StringCharacterIterator("KMGTPE");
    for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
      value >>= 10;
      ci.next();
    }
    value *= Long.signum(sizeData);
    return String.format("%.1f %ciB", value / 1024.0, ci.current());
  }

  private ProductDto createProduct(long id) {
    return ProductDto.builder()
        .id(id)
        .code("code-" + id)
        .sku("sku-" + 1)
        .description("Product description " + id)
        .build();
  }
}
