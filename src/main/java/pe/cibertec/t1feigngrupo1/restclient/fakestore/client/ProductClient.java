package pe.cibertec.t1feigngrupo1.restclient.fakestore.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.cibertec.t1feigngrupo1.restclient.fakestore.model.ProductStoreDto;

import java.util.List;

@FeignClient(
        name = "productClient",
        url = "https://fakestoreapi.com"
)
public interface ProductClient {

    @GetMapping("/products")
    List<ProductStoreDto> getProducts();
}
