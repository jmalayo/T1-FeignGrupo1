package pe.cibertec.t1feigngrupo1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.t1feigngrupo1.restclient.fakestore.model.ProductStoreDto;
import pe.cibertec.t1feigngrupo1.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductStoreDto> getProducts() {
        return productService.getFilteredProducts();
    }
}
