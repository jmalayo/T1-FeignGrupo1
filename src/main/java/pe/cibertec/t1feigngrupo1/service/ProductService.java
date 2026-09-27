package pe.cibertec.t1feigngrupo1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.t1feigngrupo1.restclient.fakestore.client.ProductClient;
import pe.cibertec.t1feigngrupo1.restclient.fakestore.model.ProductStoreDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductClient productClient;

    public List<ProductStoreDto> getFilteredProducts() {

        List<ProductStoreDto> products = productClient.getProducts();

        return products.stream()
                .filter(p -> p.getPrice() != null && p.getPrice() > 50.0)
                .filter(p -> "electronics".equalsIgnoreCase(p.getCategory()))
                .collect(Collectors.toList());
    }
}
