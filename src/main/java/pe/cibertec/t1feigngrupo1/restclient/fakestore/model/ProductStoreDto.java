package pe.cibertec.t1feigngrupo1.restclient.fakestore.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStoreDto {

    private Integer id;
    private String title;
    private Double price;
    private String category;
}
